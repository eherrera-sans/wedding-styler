package com.sanservices.websitesapi.modules.state.mapper;

import com.sanservices.websitesapi.modules.state.entity.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class StateRowMapper implements RowMapper<State> {
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();
        state.setId(rs.getInt("state_id"));
        state.setCode(rs.getString("state_code"));
        state.setName(rs.getString("state"));
        state.setCountryId(rs.getInt("country_id"));
        state.setCountryCode(rs.getString("country_code"));
        state.setCountryName(rs.getString("country"));
        return state;
    }
}
