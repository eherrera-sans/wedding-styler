package com.sanservices.websitesapi.modules.resort.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.resort.entity.Resort;
import com.sanservices.websitesapi.modules.resort.repository.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResortServiceImpl implements ResortService {

    private final ResortRepository resortRepository;

    @Override
    public List<Resort> getResortsByBrand(Brand brand) {
        return resortRepository.findByBrand(brand);
    }

    @Override
    public Resort getResortByBrandAndCode(Brand brand, String code) {
        return resortRepository.findByBrandAndCode(brand, code.toUpperCase())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
