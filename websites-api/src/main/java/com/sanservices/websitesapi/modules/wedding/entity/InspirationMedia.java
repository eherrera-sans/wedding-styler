package com.sanservices.websitesapi.modules.wedding.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public final class InspirationMedia implements Serializable {
    private static final long serialVersionUID = -6977936828318124134L;

    private int inspirationId;
    private List<String> homeCeremony;
    private List<String> homeReception;
    private String lookBookImage;
    private List<String> reception;
    private List<String> ceremony;
    private List<Video> video;
    private List<String> collectionCeremony;
    private List<String> collectionReception;
    private List<String> simpleToExtravagant;
    private String inspiredBy;

    @Data
    public static class Video implements Serializable {
        private static final long serialVersionUID = -3303424447429074158L;

        private String src;
        private String type;
    }
}
