package com.sanservices.websitesapi.modules.wedding.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public final class AccountRequestModel implements Serializable {
    private static final long serialVersionUID = -1357103676697939016L;

    @NotBlank
    private String email;

    @NotBlank
    private String lastName;

    @NotBlank
    private String countryCode;
}
