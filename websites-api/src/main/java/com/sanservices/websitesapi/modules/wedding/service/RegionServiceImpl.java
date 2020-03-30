package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Region;
import com.sanservices.websitesapi.modules.wedding.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "regions")
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<Region> getRegions(Brand brand) {
        return regionRepository.findByBrand(brand);
    }
}
