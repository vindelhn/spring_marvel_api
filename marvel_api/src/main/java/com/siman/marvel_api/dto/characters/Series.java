package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

    @JsonProperty("available")
    private long available;

    @JsonProperty("collectionURI")
    private String collectionURI;

    @JsonProperty("items")
    private List<SeriesItem> items;

    @JsonProperty("retuned")
    private long retuned;

}
