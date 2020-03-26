package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.modules.wedding.model.InspirationResponseModel;
import com.sanservices.websitesapi.modules.wedding.service.InspirationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InspirationController {

    private final InspirationService inspirationService;

    @GetMapping("/inspirations")
    public List<InspirationResponseModel> getAllInspirations() {
        return inspirationService.getAllInspirations();
    }
}
