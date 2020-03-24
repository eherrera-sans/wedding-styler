package com.sanservices.websitesapi.modules.state.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class State implements Serializable {
    private static final long serialVersionUID = 1533533100597111132L;

    private int id;
    private String code;
    private String name;
    private int countryId;
    private String countryCode;
    private String countryName;
}
