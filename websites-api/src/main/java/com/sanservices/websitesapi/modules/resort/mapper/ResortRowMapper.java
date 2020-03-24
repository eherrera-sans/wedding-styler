package com.sanservices.websitesapi.modules.resort.mapper;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public final class ResortRowMapper implements RowMapper<Resort> {

    private final ConversionService conversionService;

    @Override
    public Resort mapRow(ResultSet rs, int i) throws SQLException {
        Resort resort = new Resort();
        resort.setId(rs.getInt("resort_id"));
        resort.setCode(rs.getString("rst_code"));
        resort.setName(rs.getString("resort_name"));
        resort.setShortName(rs.getString("resort_shortName"));
        resort.setBrand(conversionService.convert(rs.getString("resort_type"), Brand.class));
        resort.setUrl(rs.getString("resort_url"));
        resort.setWebDescription(rs.getString("web_description"));
        resort.setPath(rs.getString("resort_path"));
        resort.setCity(rs.getString("resort_city"));
        resort.setCountryId(rs.getInt("country_id"));
        resort.setCountryCode(rs.getString("country_code"));
        resort.setCountryName(rs.getString("country"));
        return resort;
    }
}
