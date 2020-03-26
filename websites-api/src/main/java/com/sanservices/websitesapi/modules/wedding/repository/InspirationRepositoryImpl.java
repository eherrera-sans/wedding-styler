package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class InspirationRepositoryImpl implements InspirationRepository {

    private final SimpleJdbcCall spGetInspirations;

    public InspirationRepositoryImpl(
            @Wds JdbcTemplate template,
            RowMapper<Inspiration> inspirationRowMapper) {

        spGetInspirations = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_INSPIRATIONS")
                .declareParameters(
                        new SqlOutParameter("po_inspirations", Types.REF_CURSOR, inspirationRowMapper)
                );
        spGetInspirations.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Inspiration> findAll() {
        Map<String, Object> result = spGetInspirations.execute();
        return (List<Inspiration>) result.get("po_inspirations");
    }
}
