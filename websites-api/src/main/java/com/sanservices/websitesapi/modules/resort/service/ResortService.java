package com.sanservices.websitesapi.modules.resort.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;

import java.util.List;

public interface ResortService {
    List<Resort> getResorts(Brand brand);

    Resort getResort(Brand brand, String code);
}
