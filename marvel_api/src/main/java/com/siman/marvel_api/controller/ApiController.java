package com.siman.marvel_api.controller;

import com.siman.marvel_api.model.ApiRequest;
import com.siman.marvel_api.service.ServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path="marvel/api/v1")
public class ApiController {


    private final ServiceApi service;

    @GetMapping(value="/characters" )
    public ResponseEntity<Object> getChararters(@RequestBody ApiRequest apiRequest){
         return service.getChararters(apiRequest.getName(), apiRequest.getComics(), apiRequest.getSeries());
    }

    @GetMapping(value="/characters/byname" )
    public ResponseEntity<Object> getCharartersByName(@RequestBody ApiRequest apiRequest){
        return service.getCharartersByName(apiRequest.getName());
    }

    @GetMapping(value="/characters/{characterId}" )
    public ResponseEntity<Object> getCharartersById(@PathVariable Long characterId){
        return service.getCharartersById(characterId);
    }

    @GetMapping(value="/characters/{characterId}/comics" )
    public ResponseEntity<Object> getComicsByCharartersById(@PathVariable Long characterId){
        return service.getComicsByCharartersById(characterId);
    }

    @GetMapping(value="/characters/{characterId}/description" )
    public ResponseEntity<Object> getCharartersDescription(@PathVariable Long characterId){
        return service.getCharartersDescription(characterId);
    }

    @GetMapping(value="/characters/{characterId}/fullcomics" )
    public ResponseEntity<Object> getFullComcisByCharacterId(@PathVariable Long characterId){
        return service.getFullComcisByCharacterId(characterId);
    }

    @GetMapping(value="/comics/{comicId}" )
    public ResponseEntity<Object> getComicById(@PathVariable Long comicId){
        return service.getComicById(comicId);
    }

    @GetMapping(value="/usersearchs" )
    public ResponseEntity<Object> getUserSearchs(){
        return service.getUserSearchs();
    }

    @GetMapping(value="/usersearchs/{userName}" )
    public ResponseEntity<Object> getUserSearchsByUser(@PathVariable String userName){
        return service.getUserSearchsByUser(userName);
    }






}
