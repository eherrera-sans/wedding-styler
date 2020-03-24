package com.sanservices.websitesapi.modules.resort.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;

import java.util.List;
import java.util.Optional;

public interface ResortRepository {
    List<Resort> findByBrand(Brand brand);

    Optional<Resort> findByBrandAndCode(Brand brand, String code);
}
