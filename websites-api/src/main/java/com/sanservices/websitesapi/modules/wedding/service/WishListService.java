package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;

import java.util.List;

public interface WishListService {
    List<WishList> getWishLists(int userId, Brand brand);
}
