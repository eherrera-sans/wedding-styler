package com.sanservices.websitesapi.modules.wedding.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public final class CredentialsRequestModel implements Serializable {
    private static final long serialVersionUID = -3893507135967980817L;

    @NotBlank
    private String email;

    @NotBlank
    private String lastName;
}
