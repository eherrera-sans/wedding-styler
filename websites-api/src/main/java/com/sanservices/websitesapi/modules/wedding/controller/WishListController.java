package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;
import com.sanservices.websitesapi.modules.wedding.service.WishListService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    @GetMapping("/brands/{brand}/wish-lists")
    public List<WishList> getWishLists(
            @ApiParam(allowableValues = "b,s,beaches,sandals") @PathVariable Brand brand,
            @RequestHeader("User-Id") Integer userId) {

        return wishListService.getWishLists(userId, brand);
    }
}
