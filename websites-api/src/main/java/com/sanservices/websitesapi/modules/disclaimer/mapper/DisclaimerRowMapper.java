package com.sanservices.websitesapi.modules.disclaimer.mapper;

import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public final class DisclaimerRowMapper implements RowMapper<Disclaimer> {

    private final ConversionService conversionService;

    @Override
    public Disclaimer mapRow(ResultSet rs, int rowNum) throws SQLException {
        val disclaimer = Disclaimer.builder();
        disclaimer.setTitle(rs.getString("title"));
        disclaimer.setDescription(rs.getString("description"));
        disclaimer.setUrl(rs.getString("url"));

        val status = conversionService.convert(rs.getString("status"), Boolean.class);
        disclaimer.setStatus(status != null ? status : false);

        return disclaimer.build();
    }
}
