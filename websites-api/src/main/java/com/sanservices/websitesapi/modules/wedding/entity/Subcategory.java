package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Subcategory implements Serializable {
    private static final long serialVersionUID = -5097072613584746966L;

    private int id;
    private String name;
    private int itemCount;
    private int categoryId;
    private String categoryName;
}
