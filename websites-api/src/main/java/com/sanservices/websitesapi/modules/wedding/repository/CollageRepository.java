package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;

import java.util.List;

public interface CollageRepository {

    List<Collage> findByWishListId(int wishListId);
}
