package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;

    @JsonProperty("resourceURI")
    private String resourceURI;

    @JsonProperty("comics")
    private Comics comics;

    @JsonProperty("series")
    private Series series;


}
