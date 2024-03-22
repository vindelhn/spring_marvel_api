package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeriesItem {
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
}
