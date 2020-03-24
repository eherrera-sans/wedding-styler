package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Region implements Serializable {
    private static final long serialVersionUID = -3506714612685937873L;

    private int id;
    private String name;
}
