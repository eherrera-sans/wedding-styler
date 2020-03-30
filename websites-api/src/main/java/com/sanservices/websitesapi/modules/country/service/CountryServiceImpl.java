package com.sanservices.websitesapi.modules.country.service;

import com.sanservices.websitesapi.modules.country.entity.Country;
import com.sanservices.websitesapi.modules.country.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = " countries")
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
