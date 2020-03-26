package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;

import java.util.List;

public interface WishListRepository {
    List<WishList> findByUserIdAndBrand(int userId, Brand brand);
}
