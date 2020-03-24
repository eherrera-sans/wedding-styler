package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.config.jdbc.Source;
import com.sanservices.websitesapi.config.jdbc.Sources;
import com.sanservices.websitesapi.modules.wedding.entity.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import static com.sanservices.websitesapi.config.jdbc.Sources.Wds;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final SimpleJdbcCall spGetEvents;

    public EventRepositoryImpl(
            @Source(Wds) JdbcTemplate template,
            RowMapper<Event> eventRowMapper) {

        spGetEvents = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_EVENTS")
                .declareParameters(
                        new SqlOutParameter("po_events", Types.REF_CURSOR, eventRowMapper)
                );
        spGetEvents.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> findAll() {
        Map<String, Object> result = spGetEvents.execute();
        return (List<Event>) result.get("po_events");
    }
}
