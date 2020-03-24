package com.sanservices.websitesapi.modules.resort.controller;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;
import com.sanservices.websitesapi.modules.resort.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResortController {

    private final ResortService resortService;

    @GetMapping("/brands/{brand}/resorts")
    public List<Resort> getResortsByBrand(@PathVariable Brand brand) {
        return resortService.getResortsByBrand(brand);
    }

    @GetMapping("/brands/{brand}/resorts/{code:[a-zA-Z]{3}}")
    public Resort getResortByBrandAndCode(@PathVariable Brand brand, @PathVariable String code) {
        return resortService.getResortByBrandAndCode(brand, code);
    }
}
