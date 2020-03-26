package com.sanservices.websitesapi.modules.country.repository;

import com.sanservices.websitesapi.config.jdbc.source.SandalsWebMySql;
import com.sanservices.websitesapi.modules.country.entity.Country;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private final NamedParameterJdbcTemplate template;
    private final RowMapper<Country> countryRowMapper;

    public CountryRepositoryImpl(
            @SandalsWebMySql NamedParameterJdbcTemplate template,
            RowMapper<Country> countryRowMapper) {

        this.template = template;
        this.countryRowMapper = countryRowMapper;
    }

    @Override
    public List<Country> findAll() {
        return template.query(Sql.GET_ALL_COUNTRIES, countryRowMapper);
    }

    private static class Sql {
        public static final String GET_ALL_COUNTRIES = (
                "SELECT " +
                "  COUNTRY_ID, " +
                "  COUNTRY_CODE, " +
                "  COUNTRY, " +
                "  REGION_CODE " +
                "FROM OBE_COUNTRIES"
        ).replaceAll("\\s+", " ");
    }
}
