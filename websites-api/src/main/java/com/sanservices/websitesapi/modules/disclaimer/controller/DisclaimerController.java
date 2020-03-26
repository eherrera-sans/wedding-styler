package com.sanservices.websitesapi.modules.disclaimer.controller;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;
import com.sanservices.websitesapi.modules.disclaimer.service.DisclaimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DisclaimerController {

    private final DisclaimerService disclaimerService;

    @GetMapping("/brands/{brand}/disclaimers/{url}")
    public Disclaimer getDisclaimer(@PathVariable Brand brand, @PathVariable String url) {
        return disclaimerService.getDisclaimer(brand, url);
    }
}
