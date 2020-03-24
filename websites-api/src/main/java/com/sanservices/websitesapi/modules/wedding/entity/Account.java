package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public final class Account implements Serializable {
    private static final long serialVersionUID = 8268755395553653422L;

    private Integer id;
    private String email;
    private String lastName;
    private String countryCode;
    private boolean optedIn;
}
