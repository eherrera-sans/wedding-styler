package com.sanservices.websitesapi.modules.state.repository;

import com.sanservices.websitesapi.config.jdbc.source.SandalsWebMySql;
import com.sanservices.websitesapi.modules.state.entity.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

    private final NamedParameterJdbcTemplate template;
    private final RowMapper<State> stateRowMapper;

    public StateRepositoryImpl(
            @SandalsWebMySql NamedParameterJdbcTemplate template,
            RowMapper<State> stateRowMapper) {

        this.template = template;
        this.stateRowMapper = stateRowMapper;
    }

    @Override
    public List<State> findAll() {
        return template.query(Sql.GET_ALL_STATES, stateRowMapper);
    }

    private static final class Sql {
        public static String GET_ALL_STATES = (
                "SELECT " +
                "  s.STATE_ID, " +
                "  s.STATE_CODE, " +
                "  s.STATE, " +
                "  c.COUNTRY_ID, " +
                "  c.COUNTRY_CODE, " +
                "  c.COUNTRY " +
                "FROM OBE_STATES s " +
                "  INNER JOIN OBE_COUNTRIES c " +
                "    ON c.COUNTRY_ID = s.COUNTRY_ID"
        ).replaceAll("\\s+", " ");
    }
}
