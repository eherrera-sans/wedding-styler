package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.modules.wedding.entity.Event;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();
}
