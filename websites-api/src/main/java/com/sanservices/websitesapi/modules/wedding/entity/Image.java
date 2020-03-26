package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Image implements Serializable {
    private static final long serialVersionUID = -235748948088652414L;

    private String path;
    private String name;
}
