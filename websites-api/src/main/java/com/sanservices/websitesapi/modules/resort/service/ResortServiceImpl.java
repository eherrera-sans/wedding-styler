package com.sanservices.websitesapi.modules.resort.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;
import com.sanservices.websitesapi.modules.resort.repository.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "resorts")
public class ResortServiceImpl implements ResortService {

    private final ResortRepository resortRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<Resort> getResorts(Brand brand) {
        return resortRepository.findByBrand(brand);
    }

    @Cacheable
    @Override
    public Resort getResort(Brand brand, String code) {
        return resortRepository.findByBrandAndCode(brand, code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
