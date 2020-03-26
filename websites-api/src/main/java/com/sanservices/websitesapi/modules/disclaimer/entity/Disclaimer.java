package com.sanservices.websitesapi.modules.disclaimer.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(setterPrefix = "set")
public final class Disclaimer implements Serializable {
    private static final long serialVersionUID = 3803871482176619277L;

    private final String title;
    private final String description;
    private final String url;
    private final boolean status;
}
