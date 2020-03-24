package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Region;

import java.util.List;

public interface RegionRepository {
    List<Region> findByBrand(Brand brand);
}
