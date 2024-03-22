package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnail {

    @JsonProperty("path")
    private String path;

    @JsonProperty("extension")
    private String extension;
}
