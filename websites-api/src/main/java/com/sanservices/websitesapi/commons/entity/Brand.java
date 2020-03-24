package com.sanservices.websitesapi.commons.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jooq.lambda.Seq;

import java.util.List;

@RequiredArgsConstructor
@Getter
public enum Brand {
    SANDALS("S"), BEACHES("B");

    private final String code;

    public static List<String> getCodes() {
        return Seq.of(values())
                .map(Brand::getCode)
                .map(String::toUpperCase)
                .toList();
    }

    public static List<String> getNames() {
        return Seq.of(values())
                .map(Brand::name)
                .map(String::toUpperCase)
                .toList();
    }
}
