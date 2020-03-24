package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Event implements Serializable {
    private static final long serialVersionUID = -6891487366476634396L;

    private int id;
    private String name;
}
