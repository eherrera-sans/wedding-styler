package com.sanservices.websitesapi.modules.disclaimer.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.commons.extractor.OptionalResultSetExtractor;
import com.sanservices.websitesapi.config.jdbc.source.SandalsWebOracle;
import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.Types;
import java.util.Optional;

@Repository
public class DisclaimerRepositoryImpl implements DisclaimerRepository {

    private final NamedParameterJdbcTemplate template;

    private final OptionalResultSetExtractor<Disclaimer> optionalDisclaimerExtractor;

    public DisclaimerRepositoryImpl(
            @SandalsWebOracle NamedParameterJdbcTemplate template,
            RowMapper<Disclaimer> disclaimerRowMapper) {

        this.template = template;
        this.optionalDisclaimerExtractor = new OptionalResultSetExtractor<>(disclaimerRowMapper);
    }

    @Override
    public Optional<Disclaimer> findByBrandAndUrl(Brand brand, String url) {
        val params = new MapSqlParameterSource();
        params.addValue("brand", "%" + brand.getCode() + "%", Types.VARCHAR, JDBCType.VARCHAR.getName());
        params.addValue("url", url.toUpperCase(), Types.VARCHAR, JDBCType.VARCHAR.getName());

        return template.query(GET_DISCLAIMER_BY_BRAND_AND_URL, params, optionalDisclaimerExtractor);
    }

    private static final String GET_DISCLAIMER_BY_BRAND_AND_URL = (
            "SELECT " +
            "  title, " +
            "  description, " +
            "  status, " +
            "  url " +
            "FROM disclaimers " +
            "WHERE brand LIKE :brand " +
            "  AND UPPER(url) = :url"
    ).replaceAll("\\s+", " ");
}
