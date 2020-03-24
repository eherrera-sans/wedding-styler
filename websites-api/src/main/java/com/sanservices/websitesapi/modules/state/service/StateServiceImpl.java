package com.sanservices.websitesapi.modules.state.service;

import com.sanservices.websitesapi.modules.state.entity.State;
import com.sanservices.websitesapi.modules.state.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
