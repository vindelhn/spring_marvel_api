package com.siman.marvel_api.dto.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicRoot {

    @JsonProperty("code")
    private long code;

    @JsonProperty("status")
    private String status;

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("attributionText")
    private String attributionText;

    @JsonProperty("attributionHTML")
    private String attributionHTML;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("data")
    private ComicData data;
}
