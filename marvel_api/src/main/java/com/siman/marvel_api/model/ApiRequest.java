package com.siman.marvel_api.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest {

    private String name;
    private Integer comics;
    private Integer series;


}
