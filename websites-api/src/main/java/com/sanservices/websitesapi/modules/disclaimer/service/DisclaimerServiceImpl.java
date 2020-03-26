package com.sanservices.websitesapi.modules.disclaimer.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;
import com.sanservices.websitesapi.modules.disclaimer.repository.DisclaimerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DisclaimerServiceImpl implements DisclaimerService {

    private final DisclaimerRepository disclaimerRepository;

    @Override
    public Disclaimer getDisclaimer(Brand brand, String url) {
        return disclaimerRepository.findByBrandAndUrl(brand, url)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disclaimer not found"));
    }
}
