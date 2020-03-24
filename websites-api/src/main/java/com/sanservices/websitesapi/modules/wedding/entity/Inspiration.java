package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Inspiration implements Serializable {
    private static final long serialVersionUID = -3840718418930490721L;

    private int id;
    private String name;
    private String description;
}
