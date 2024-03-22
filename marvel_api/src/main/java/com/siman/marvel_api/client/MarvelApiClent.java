package com.siman.marvel_api.client;


import com.siman.marvel_api.model.ApiRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${marvel.api.url}", name = "marvel-api")
public interface MarvelApiClent {


    @GetMapping(path = "/characters", produces = "application/json")
    ResponseEntity<Object> getChararters( @RequestParam String name,
                                          @RequestParam int series,
                                          @RequestParam int comics,
                                          @RequestParam String apikey,
                                          @RequestParam String hash,
                                          @RequestParam String ts
    );

    @GetMapping(path = "/characters", produces = "application/json")
    ResponseEntity<Object> getCharartersByName( @RequestParam String name,
                                          @RequestParam String apikey,
                                          @RequestParam String hash,
                                          @RequestParam String ts
    );

    @GetMapping(path = "/characters/{characterId}", produces = "application/json")
    ResponseEntity<Object> getCharartersById( @PathVariable Long characterId,
                                              @RequestParam String apikey,
                                              @RequestParam String hash,
                                              @RequestParam String ts
    );

    @GetMapping(path = "/characters/{characterId}", produces = "application/json")
    ResponseEntity<Object> getComicsByCharartersById( @PathVariable Long characterId,
                                              @RequestParam String apikey,
                                              @RequestParam String hash,
                                              @RequestParam String ts
    );

    @GetMapping(path = "/characters/{characterId}", produces = "application/json")
    ResponseEntity<Object> getCharartersNameAndImage( @PathVariable Long characterId,
                                                      @RequestParam String apikey,
                                                      @RequestParam String hash,
                                                      @RequestParam String ts
    );

    @GetMapping(path = "/characters/{characterId}/comics", produces = "application/json")
    ResponseEntity<Object> getFullComcisByCharacterId( @PathVariable Long characterId,
                                                      @RequestParam String apikey,
                                                      @RequestParam String hash,
                                                      @RequestParam String ts
    );

    @GetMapping(path = "/comics/{comicId}", produces = "application/json")
    ResponseEntity<Object> getComicById( @PathVariable Long comicId,
                                                       @RequestParam String apikey,
                                                       @RequestParam String hash,
                                                       @RequestParam String ts
    );


}
