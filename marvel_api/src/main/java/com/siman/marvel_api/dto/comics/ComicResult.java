package com.siman.marvel_api.dto.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicResult {

    @JsonProperty("id")
    private long id;

    @JsonProperty("digitalID")
    private long digitalID;

    @JsonProperty("title")
    private String title;

    @JsonProperty("issueNumber")
    private long issueNumber;

    @JsonProperty("variantDescription")
    private String variantDescription;

    @JsonProperty("description")
    private String description;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("upc")
    private String upc;

    @JsonProperty("diamondCode")
    private String diamondCode;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("issn")
    private String issn;

    @JsonProperty("format")
    private String format;

    @JsonProperty("pageCount")
    private long pageCount;

    @JsonProperty("resourceURI")
    private String resourceURI;

    @JsonProperty("urls")
    private List<URL> urls;

    @JsonProperty("dates")
    private List<Date> dates;

    @JsonProperty("prices")
    private List<Price> prices;

    @JsonProperty("thumbnail")
    private ComicThumbnail thumbnail;

    @JsonProperty("images")
    private List<ComicThumbnail> images;





}
