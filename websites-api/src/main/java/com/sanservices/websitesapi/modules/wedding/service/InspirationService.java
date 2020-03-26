package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.model.InspirationResponseModel;

import java.util.List;

public interface InspirationService {
    List<InspirationResponseModel> getAllInspirations();
}
