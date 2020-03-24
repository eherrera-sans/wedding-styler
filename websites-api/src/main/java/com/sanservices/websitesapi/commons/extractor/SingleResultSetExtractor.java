package com.sanservices.websitesapi.commons.extractor;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public final class SingleResultSetExtractor<T> implements ResultSetExtractor<T> {

    private final RowMapper<T> rowMapper;

    @Override
    public T extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            return rowMapper.mapRow(rs, 1);
        } else {
            return null;
        }
    }
}
