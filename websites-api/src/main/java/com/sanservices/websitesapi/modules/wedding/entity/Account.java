package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set", toBuilder = true)
public final class Account implements Serializable {
    private static final long serialVersionUID = 8268755395553653422L;

    private Integer id;
    private String email;
    private String lastName;
    private String countryCode;
    private boolean optedIn;
}
