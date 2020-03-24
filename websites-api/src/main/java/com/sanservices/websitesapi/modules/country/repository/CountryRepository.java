package com.sanservices.websitesapi.modules.country.repository;

import com.sanservices.websitesapi.modules.country.entity.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> findAll();
}
