package com.sanservices.websitesapi.modules.disclaimer.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.disclaimer.entity.Disclaimer;

public interface DisclaimerService {
    Disclaimer getDisclaimer(Brand brand, String url);
}
