package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Root {

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
    private Data data;

}
