package com.siman.marvel_api.dto.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicData {

    @JsonProperty("offset")
    private long offset;

    @JsonProperty("limit")
    private long limit;

    @JsonProperty("total")
    private long total;

    @JsonProperty("count")
    private long count;

    @JsonProperty("results")
    private List<ComicResult> results;

}
