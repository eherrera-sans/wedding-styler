package com.sanservices.websitesapi.modules.state.service;

import com.sanservices.websitesapi.modules.state.entity.State;
import com.sanservices.websitesapi.modules.state.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "states")
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<State> getStates() {
        return stateRepository.findAll();
    }
}
