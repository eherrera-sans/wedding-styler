package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Collage implements Serializable {
    private static final long serialVersionUID = 3464991685382863886L;

    private String event;
    private int position;
    private int subcategoryId;
    private String subcategoryName;
    private Integer attributeId;
    private Image image;
}
