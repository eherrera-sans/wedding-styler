package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;
import com.sanservices.websitesapi.modules.wedding.repository.CollageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "collages")
public class CollageServiceImpl implements CollageService {

    private final CollageRepository collageRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<Collage> getCollageData(int wishListId) {
        return collageRepository.findByWishListId(wishListId);
    }
}
