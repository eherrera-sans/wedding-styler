package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Region;
import com.sanservices.websitesapi.modules.wedding.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/brands/{brand}/regions")
    public List<Region> getRegionsByBrand(@PathVariable Brand brand) {
        return regionService.getRegions(brand);
    }
}
