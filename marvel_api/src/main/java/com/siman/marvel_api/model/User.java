package com.siman.marvel_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class User {

    @Id
    private String username;
    private String password;
    @NotEmpty
    private String name;

}
