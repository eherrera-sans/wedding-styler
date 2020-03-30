package com.sanservices.websitesapi.commons.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Brand {
    SANDALS("S"), BEACHES("B");

    private final String code;
}
