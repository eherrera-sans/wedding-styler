package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Result;
import com.sanservices.websitesapi.commons.extractor.SingleResultSetExtractor;
import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.entity.Credentials;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.Types;
import java.util.Map;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final SimpleJdbcCall spCreateAccount;
    private final SimpleJdbcCall spVerifyLogin;

    public AccountRepositoryImpl(
            @Wds JdbcTemplate template,
            RowMapper<Result<Account, String>> accountResultRowMapper) {

        spCreateAccount = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("CREATE_ACCOUNT")
                .declareParameters(
                        new SqlParameter("pi_email", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlParameter("pi_lastName", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlParameter("pi_country", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlParameter("pi_optedIn", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlOutParameter("po_userId", Types.INTEGER, JDBCType.INTEGER.getName()),
                        new SqlOutParameter("po_message", Types.VARCHAR, JDBCType.VARCHAR.getName())
                );
        spCreateAccount.compile();

        spVerifyLogin = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("VERIFY_LOGIN")
                .declareParameters(
                        new SqlParameter("pi_email", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlParameter("pi_lastName", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlOutParameter("po_login", Types.REF_CURSOR,
                                new SingleResultSetExtractor<>(accountResultRowMapper))
                );
        spVerifyLogin.compile();
    }

    @Override
    public Result<Account, String> save(Account account) {
        val params = new MapSqlParameterSource();
        params.addValue("pi_email", account.getEmail());
        params.addValue("pi_lastName", account.getLastName());
        params.addValue("pi_country", account.getCountryCode());
        params.addValue("pi_optedIn", (account.isOptedIn() ? "Y" : "N"));

        val result = spCreateAccount.execute(params);
        val message = (String) result.get("po_message");
        if (message.equalsIgnoreCase("success")) {
            val userId = (Integer) result.get("po_userId");
            return Result.success(account.toBuilder().setId(userId).build());
        } else {
            return Result.failure(message);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Result<Account, String> login(Credentials credentials) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("pi_email", credentials.getEmail());
        params.addValue("pi_lastName", credentials.getLastName());

        Map<String, Object> result = spVerifyLogin.execute(params);
        return (Result<Account, String>) result.get("po_login");
    }
}
