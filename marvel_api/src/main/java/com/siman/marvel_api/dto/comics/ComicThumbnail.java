package com.siman.marvel_api.dto.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicThumbnail {

    @JsonProperty("path")
    public String path;

    @JsonProperty("extension")
    public String extension;
}