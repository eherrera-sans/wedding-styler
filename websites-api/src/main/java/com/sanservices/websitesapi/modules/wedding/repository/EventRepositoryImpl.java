package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.Event;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final SimpleJdbcCall spGetEvents;

    public EventRepositoryImpl(
            @Wds JdbcTemplate template,
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
        val result = spGetEvents.execute();
        return (List<Event>) result.get("po_events");
    }
}
