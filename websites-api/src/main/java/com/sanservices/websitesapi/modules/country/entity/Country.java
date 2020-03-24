package com.sanservices.websitesapi.modules.country.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Country implements Serializable {
    private static final long serialVersionUID = 6623396722338822569L;

    private int id;
    private String code;
    private String name;
    private String regionCode;
}
