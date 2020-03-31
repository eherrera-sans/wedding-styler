package com.sanservices.websitesapi.modules.wedding.model;

import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;
import com.sanservices.websitesapi.modules.wedding.entity.InspirationMedia;
import lombok.Data;

import java.io.Serializable;

@Data
public final class InspirationResponseModel implements Serializable {
    private static final long serialVersionUID = 6861035251069911139L;

    private Inspiration inspiration;
    private InspirationMedia media;
}
