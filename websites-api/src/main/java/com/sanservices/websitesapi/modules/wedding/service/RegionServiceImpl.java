package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Region;
import com.sanservices.websitesapi.modules.wedding.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public List<Region> getRegionsByBrand(Brand brand) {
        return regionRepository.findByBrand(brand);
    }
}
