package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;
import com.sanservices.websitesapi.modules.wedding.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "wish-lists")
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<WishList> getWishLists(int userId, Brand brand) {
        return wishListRepository.findByUserIdAndBrand(userId, brand);
    }
}
