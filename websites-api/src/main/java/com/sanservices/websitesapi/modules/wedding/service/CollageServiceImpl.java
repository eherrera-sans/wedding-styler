package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;
import com.sanservices.websitesapi.modules.wedding.repository.CollageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollageServiceImpl implements CollageService {

    private final CollageRepository collageRepository;

    @Override
    public List<Collage> getCollageDataByWishListId(int wishListId) {
        return collageRepository.findByWishListId(wishListId);
    }
}
