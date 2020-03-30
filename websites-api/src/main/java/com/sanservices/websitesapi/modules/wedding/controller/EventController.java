package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.model.EventResponseModel;
import com.sanservices.websitesapi.modules.wedding.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/brands/{brand}/events")
    public List<EventResponseModel> getEventsByBrand(@PathVariable Brand brand) {
        return eventService.getEvents(brand);
    }
}
