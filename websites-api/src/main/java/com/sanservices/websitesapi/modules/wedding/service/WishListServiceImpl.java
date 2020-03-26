package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;
import com.sanservices.websitesapi.modules.wedding.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    @Override
    public List<WishList> getWishLists(int userId, Brand brand) {
        return wishListRepository.findByUserIdAndBrand(userId, brand);
    }
}
