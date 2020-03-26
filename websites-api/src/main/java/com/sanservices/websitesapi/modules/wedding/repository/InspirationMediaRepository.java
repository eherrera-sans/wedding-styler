package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.modules.wedding.entity.InspirationMedia;

import java.util.Optional;

public interface InspirationMediaRepository {
    Optional<InspirationMedia> findByInspirationId(int inspirationId);
}
