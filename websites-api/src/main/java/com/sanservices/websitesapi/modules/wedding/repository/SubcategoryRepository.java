package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.modules.wedding.entity.Subcategory;

import java.util.List;

public interface SubcategoryRepository {
    List<Subcategory> findByEventIdAndBrand(int eventId, Brand brand);
}
