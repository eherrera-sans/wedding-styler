package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public final class Credentials implements Serializable {
    private static final long serialVersionUID = -7935489505242142502L;

    @NotBlank
    private String email;

    @NotBlank
    private String lastName;
}
