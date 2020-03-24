package com.sanservices.websitesapi.modules.resort.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.commons.extractor.OptionalResultSetExtractor;
import com.sanservices.websitesapi.config.jdbc.Source;
import com.sanservices.websitesapi.modules.resort.entity.Resort;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import static com.sanservices.websitesapi.config.jdbc.Sources.SandalsWebOracle;

@Repository
public class ResortRepositoryImpl implements ResortRepository {

    private final NamedParameterJdbcTemplate template;
    private final RowMapper<Resort> resortRowMapper;

    public ResortRepositoryImpl(
            @Source(SandalsWebOracle) NamedParameterJdbcTemplate template,
            RowMapper<Resort> resortRowMapper) {

        this.template = template;
        this.resortRowMapper = resortRowMapper;
    }

    @Override
    public List<Resort> findByBrand(Brand brand) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("brand", brand.getCode(), Types.VARCHAR, JDBCType.VARCHAR.getName());

        return template.query(Sql.GET_RESORTS_BY_BRAND, params, resortRowMapper);
    }

    @Override
    public Optional<Resort> findByBrandAndCode(Brand brand, String code) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("brand", brand.getCode(), Types.VARCHAR, JDBCType.VARCHAR.getName());
        params.addValue("code", code, Types.VARCHAR, JDBCType.VARCHAR.getName());

        OptionalResultSetExtractor<Resort> extractor = new OptionalResultSetExtractor<>(resortRowMapper);

        return template.query(Sql.GET_RESORTS_BY_BRAND_AND_CODE, params, extractor);
    }

    private static final class Sql {

        public static final String GET_RESORTS_BY_BRAND = (
                "SELECT " +
                "  RESORT_ID, " +
                "  RST_CODE, " +
                "  RESORT_NAME, " +
                "  RESORT_SHORTNAME, " +
                "  RESORT_TYPE, " +
                "  RESORT_URL, " +
                "  WEB_DESCRIPTION," +
                "  RESORT_PATH, " +
                "  RESORT_CITY, " +
                "  c.COUNTRY_ID, " +
                "  c.COUNTRY_CODE, " +
                "  c.COUNTRY " +
                "FROM RESORTS r " +
                "  INNER JOIN OBE_COUNTRIES c " +
                "    ON r.COUNTRY_ID = c.COUNTRY_ID " +
                "WHERE RESORT_TYPE = :brand " +
                "  AND IS_ACTIVE = 1"
        ).replaceAll("\\s+", " ");

        public static final String GET_RESORTS_BY_BRAND_AND_CODE = (
                "SELECT " +
                "  RESORT_ID, " +
                "  RST_CODE, " +
                "  RESORT_NAME, " +
                "  RESORT_SHORTNAME, " +
                "  RESORT_TYPE, " +
                "  RESORT_URL, " +
                "  WEB_DESCRIPTION," +
                "  RESORT_PATH, " +
                "  RESORT_CITY, " +
                "  c.COUNTRY_ID, " +
                "  c.COUNTRY_CODE, " +
                "  c.COUNTRY " +
                "FROM RESORTS r " +
                "  INNER JOIN OBE_COUNTRIES c " +
                "    ON r.COUNTRY_ID = c.COUNTRY_ID " +
                "WHERE RESORT_TYPE = :brand " +
                "  AND RST_CODE = :code " +
                "  AND IS_ACTIVE = 1"
        ).replaceAll("\\s+", " ");
    }
}
