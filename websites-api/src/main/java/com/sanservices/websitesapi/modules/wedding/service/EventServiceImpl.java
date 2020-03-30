package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.config.jdbc.tx.WdsTx;
import com.sanservices.websitesapi.modules.wedding.model.EventResponseModel;
import com.sanservices.websitesapi.modules.wedding.repository.EventRepository;
import com.sanservices.websitesapi.modules.wedding.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.lambda.Seq.seq;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "events")
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final SubcategoryRepository subcategoryRepository;

    @WdsTx
    @Cacheable(unless = "#result.empty")
    @Override
    public List<EventResponseModel> getEvents(Brand brand) {
        return seq(eventRepository.findAll()).map(event -> {
            val model = new EventResponseModel();
            model.setEvent(event);
            model.setSubcategories(subcategoryRepository.findByEventIdAndBrand(event.getId(), brand));
            return model;
        }).toList();
    }
}
