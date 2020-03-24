package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class AccountRowMapper implements RowMapper<Account> {

    private final ConversionService conversionService;

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("user_id"));
        account.setEmail(rs.getString("email"));
        account.setCountryCode(rs.getString("country_code"));
        account.setLastName(rs.getString("last_name"));

        Boolean optedIn = conversionService.convert(rs.getString("email_optin_flag"), Boolean.class);
        account.setOptedIn(optedIn != null ? optedIn : false);

        return account;
    }
}
