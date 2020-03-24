package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;
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
    public List<Inspiration> getAllInspirations() {
        return inspirationService.getAllInspirations();
    }
}
