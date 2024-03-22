package com.siman.marvel_api.dto.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class URL {

    @JsonProperty("type")
    public String type;

    @JsonProperty("url")
    public String url;

}
