package com.sanservices.websitesapi.modules.country.service;

import com.sanservices.websitesapi.modules.country.entity.Country;
import com.sanservices.websitesapi.modules.country.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
