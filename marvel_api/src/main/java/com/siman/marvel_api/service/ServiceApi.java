package com.siman.marvel_api.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.siman.marvel_api.client.MarvelApiClent;
import com.siman.marvel_api.dto.characters.Root;
import com.siman.marvel_api.dto.comics.ComicResult;
import com.siman.marvel_api.dto.comics.ComicRoot;
import com.siman.marvel_api.model.CharacterDescription;
import com.siman.marvel_api.model.UserSearch;
import com.siman.marvel_api.repository.UserRepository;
import com.siman.marvel_api.repository.UserSearchRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceApi {

    private final MarvelApiClent marvelApiClent;

    private final UserSearchRepository userSearchRepository;


    @Value("${marvel.api.publickey}")
    public String publicKey;

    @Value("${marvel.api.privatekey}")
    public String privateKey;



    public ResponseEntity<Object> getChararters(String name, int comics, int series){

      ResponseEntity<Object> response = null;

      try {

        Long ts = getTimeStamp();

        String hash = generateHash(ts,privateKey,publicKey);

        response = marvelApiClent.getChararters(name, series,comics,publicKey,hash,ts.toString());

        ObjectMapper objectMapper = new ObjectMapper();

        Root root = objectMapper.convertValue(response.getBody(), Root.class);

        saveToUserSearch(name);

        return new ResponseEntity<>(root.getData().getResults(), HttpStatus.OK);

      } catch (RuntimeException e) {
        throw new RuntimeException( e.getMessage());
      }

    }

    public ResponseEntity<Object> getCharartersByName(String name){

        ResponseEntity<Object> response = null;

        try {

            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getCharartersByName(name,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            Root root = objectMapper.convertValue(response.getBody(), Root.class);

            saveToUserSearch(name);

            return new ResponseEntity<>(root.getData().getResults(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getCharartersById(Long id){

        ResponseEntity<Object> response = null;

        try {

            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getCharartersById(id,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            Root root = objectMapper.convertValue(response.getBody(), Root.class);

            saveToUserSearch(id.toString());

            return new ResponseEntity<>(root.getData().getResults(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getComicsByCharartersById(Long id){

        ResponseEntity<Object> response = null;

        try {
            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getComicsByCharartersById(id,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            Root root = objectMapper.convertValue(response.getBody(), Root.class);

            saveToUserSearch(id.toString());

            return new ResponseEntity<>(root.getData().getResults().get(0).getComics(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getCharartersDescription(Long id){

        ResponseEntity<Object> response = null;

        try {

            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getComicsByCharartersById(id,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            Root root = objectMapper.convertValue(response.getBody(), Root.class);

            CharacterDescription characterDescription = new CharacterDescription();

            characterDescription.setName(root.getData().getResults().get(0).getName());
            characterDescription.setThumbnail( root.getData().getResults().get(0).getThumbnail().getPath()+"."+root.getData().getResults().get(0).getThumbnail().getExtension());

            saveToUserSearch(id.toString());

            return new ResponseEntity<>(characterDescription, HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getFullComcisByCharacterId(Long id){

        ResponseEntity<Object> response = null;

        try {

            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getFullComcisByCharacterId(id,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            ComicRoot result = objectMapper.convertValue(response.getBody(), ComicRoot.class);

            saveToUserSearch(id.toString());

            return new ResponseEntity<>(result.getData().getResults(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }


    public ResponseEntity<Object> getComicById(Long id){

        ResponseEntity<Object> response = null;

        try {

            Long ts = getTimeStamp();

            String hash = generateHash(ts,privateKey,publicKey);

            response = marvelApiClent.getComicById(id,publicKey,hash,ts.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            ComicRoot result = objectMapper.convertValue(response.getBody(), ComicRoot.class);

            saveToUserSearch(id.toString());

            return new ResponseEntity<>(result.getData().getResults(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getUserSearchs(){

        ResponseEntity<Object> response = null;

        try {

            List<UserSearch> userSearches =  userSearchRepository.findAll();

            return new ResponseEntity<>(userSearches, HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }

    public ResponseEntity<Object> getUserSearchsByUser(String username){

        ResponseEntity<Object> response = null;

        try {

            List<UserSearch> userSearches =  userSearchRepository.findAllByUsername(username);

            return new ResponseEntity<>(userSearches, HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException( e.getMessage());
        }

    }


    public void saveToUserSearch(String descr){

        Date date = new Date();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserSearch userSearch = new UserSearch();

        userSearch.setUsername( authentication.getName());

        userSearch.setDate( date  );

        userSearch.setDescr(descr);

        userSearchRepository.save(userSearch);
    }


    public long getTimeStamp(){
        return System.currentTimeMillis();
    }

    String generateHash(long ts, String privateKey, String publicKey) {
        String password = ts + privateKey + publicKey;
        return DigestUtils.md5Hex(password);
    }

}
