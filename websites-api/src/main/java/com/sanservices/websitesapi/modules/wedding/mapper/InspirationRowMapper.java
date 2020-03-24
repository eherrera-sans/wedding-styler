package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class InspirationRowMapper implements RowMapper<Inspiration> {
    @Override
    public Inspiration mapRow(ResultSet rs, int rowNum) throws SQLException {
        Inspiration inspiration = new Inspiration();
        inspiration.setId(rs.getInt("inspiration_id"));
        inspiration.setName(rs.getString("inspiration_name"));
        inspiration.setDescription(rs.getString("description"));
        return inspiration;
    }
}
