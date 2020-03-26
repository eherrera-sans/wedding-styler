package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public final class WishList implements Serializable {
    private static final long serialVersionUID = -697335145169142849L;

    private int id;
    private String code;
    private String name;
    private int regionId;
    private BigDecimal total;
    private BigDecimal credit;
    private BigDecimal balance;
    private Date lastUpdate;
    private int itemCount;
}
