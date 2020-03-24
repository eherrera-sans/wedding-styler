package com.sanservices.websitesapi.commons.converter;

import com.sanservices.websitesapi.commons.entity.Brand;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class StringToBrandConverter implements Converter<String, Brand> {
    @Override
    public Brand convert(String source) {
        for (Brand brand : Brand.values()) {
            if (brand.name().equalsIgnoreCase(source) || brand.getCode().equalsIgnoreCase(source)) {
                return brand;
            }
        }

        throw new IllegalArgumentException("Invalid brand '" + source + '\'');
    }
}
