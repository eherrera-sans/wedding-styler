package com.sanservices.websitesapi.modules.country.controller;

import com.sanservices.websitesapi.modules.country.entity.Country;
import com.sanservices.websitesapi.modules.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getCountries();
    }
}
