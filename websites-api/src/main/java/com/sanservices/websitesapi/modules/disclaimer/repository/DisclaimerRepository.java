package com.sanservices.websitesapi.modules.disclaimer.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;

import java.util.Optional;

public interface DisclaimerRepository {
    Optional<Disclaimer> findByBrandAndUrl(Brand brand, String url);
}
