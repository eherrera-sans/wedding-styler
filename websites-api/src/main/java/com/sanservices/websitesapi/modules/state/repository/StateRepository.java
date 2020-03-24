package com.sanservices.websitesapi.modules.state.repository;

import com.sanservices.websitesapi.modules.state.entity.State;

import java.util.List;

public interface StateRepository {
    List<State> findAll();
}
