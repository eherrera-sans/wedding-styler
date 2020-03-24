package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Region;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class RegionRowMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        val region = new Region();
        region.setId(rs.getInt("region_id"));
        region.setName(rs.getString("region_name"));
        return region;
    }
}
