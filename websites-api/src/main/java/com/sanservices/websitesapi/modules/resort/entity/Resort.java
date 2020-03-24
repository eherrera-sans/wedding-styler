package com.sanservices.websitesapi.modules.resort.entity;

import com.sanservices.websitesapi.commons.entity.Brand;
import lombok.Data;

import java.io.Serializable;

@Data
public final class Resort implements Serializable {
    private static final long serialVersionUID = 2240644015245506642L;

    private int id;
    private String code;
    private String name;
    private String shortName;
    private Brand brand;
    private String url;
    private String webDescription;
    private String path;
    private String city;
    private int countryId;
    private String countryCode;
    private String countryName;
}
