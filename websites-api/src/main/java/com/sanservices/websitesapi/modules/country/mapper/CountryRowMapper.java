package com.sanservices.websitesapi.modules.country.mapper;

import com.sanservices.websitesapi.modules.country.entity.Country;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int i) throws SQLException {
        Country country = new Country();
        country.setId(rs.getInt("country_id"));
        country.setCode(rs.getString("country_code"));
        country.setName(rs.getString("country"));
        country.setRegionCode(rs.getString("region_code"));
        return country;
    }
}
