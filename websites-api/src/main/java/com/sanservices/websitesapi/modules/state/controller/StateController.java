package com.sanservices.websitesapi.modules.state.controller;

import com.sanservices.websitesapi.modules.state.entity.State;
import com.sanservices.websitesapi.modules.state.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping("/states")
    public List<State> getAllStates() {
        return stateService.getStates();
    }
}
