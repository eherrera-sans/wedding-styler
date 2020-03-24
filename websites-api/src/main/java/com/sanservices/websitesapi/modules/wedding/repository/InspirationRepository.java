package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;

import java.util.List;

public interface InspirationRepository {
    List<Inspiration> findAll();
}
