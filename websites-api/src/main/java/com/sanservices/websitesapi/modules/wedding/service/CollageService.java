package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;

import java.util.List;

public interface CollageService {
    List<Collage> getCollageData(int wishListId);
}
