package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegions(Brand brand);
}
