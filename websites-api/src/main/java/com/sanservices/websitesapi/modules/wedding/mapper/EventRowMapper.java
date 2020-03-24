package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Event;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getInt("event_id"));
        event.setName(rs.getString("event_attribute"));
        return event;
    }
}
