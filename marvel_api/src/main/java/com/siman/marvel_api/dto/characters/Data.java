package com.siman.marvel_api.dto.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @JsonProperty("offset")
    private long offset;

    @JsonProperty("limit")
    private long limit;

    @JsonProperty("total")
    private long total;

    @JsonProperty("count")
    private long count;

    @JsonProperty("results")
    private List<Result> results;
}
