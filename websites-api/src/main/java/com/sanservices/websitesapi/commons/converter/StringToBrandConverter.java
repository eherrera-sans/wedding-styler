package com.sanservices.websitesapi.commons.converter;

import com.sanservices.websitesapi.commons.entity.Brand;
import lombok.val;
import org.jooq.lambda.Seq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public final class StringToBrandConverter implements Converter<String, Brand> {

    private final Map<String, Brand> brandMap;

    public StringToBrandConverter() {
        brandMap = new HashMap<>(Brand.values().length * 2);
        brandMap.putAll(Seq.of(Brand.values()).toMap(brand -> brand.getCode().toUpperCase()));
        brandMap.putAll(Seq.of(Brand.values()).toMap(brand -> brand.name().toUpperCase()));
    }

    @Override
    public Brand convert(String source) {
        val brand = brandMap.get(source.toUpperCase());
        if (brand != null) {
            return brand;
        }

        throw new IllegalArgumentException("Invalid brand '" + source + '\'');
    }
}
