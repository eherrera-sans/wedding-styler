package com.sanservices.websitesapi.modules.wedding.model;

import com.sanservices.websitesapi.modules.wedding.entity.Event;
import com.sanservices.websitesapi.modules.wedding.entity.Subcategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public final class EventResponseModel implements Serializable {
    private static final long serialVersionUID = 4724055432615561376L;

    private Event event;
    private List<Subcategory> subcategories;
}
