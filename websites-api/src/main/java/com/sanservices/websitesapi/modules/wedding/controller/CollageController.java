package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;
import com.sanservices.websitesapi.modules.wedding.service.CollageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public final class CollageController {

    private final CollageService collageService;

    @GetMapping("/wish-lists/{wishListId}/collage")
    public List<Collage> getCollageDataByWishListId(@PathVariable Integer wishListId) {
        return collageService.getCollageData(wishListId);
    }
}
