package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.model.EventResponseModel;

import java.util.List;

public interface EventService {
    List<EventResponseModel> getEventsByBrand(Brand brand);
}
