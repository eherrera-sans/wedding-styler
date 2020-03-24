package com.sanservices.websitesapi.commons.extractor;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
public class OptionalResultSetExtractor<T> implements ResultSetExtractor<Optional<T>> {

    private final RowMapper<T> rowMapper;

    @Override
    public Optional<T> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            return Optional.ofNullable(rowMapper.mapRow(rs, 1));
        } else {
            return Optional.empty();
        }
    }
}
