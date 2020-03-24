package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.commons.entity.Result;
import com.sanservices.websitesapi.modules.wedding.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public final class AccountResultRowMapper implements RowMapper<Result<Account, String>> {

    private final RowMapper<Account> accountRowMapper;

    @Override
    public Result<Account, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        String message = rs.getString("message");
        if (message.equalsIgnoreCase("success")) {
            return Result.success(accountRowMapper.mapRow(rs, rowNum));
        } else {
            return Result.failure(message);
        }
    }
}
