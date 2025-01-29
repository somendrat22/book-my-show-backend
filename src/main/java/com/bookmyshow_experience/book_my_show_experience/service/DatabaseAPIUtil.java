package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.exceptions.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

@Service
public class DatabaseAPIUtil {

    @Value("${db.api.url}")
    String dbApiUrl;

    public void createUser(CreateUserRB createUserRB){
        // Calling DB API to save user
        String finalUrl = dbApiUrl + "/user/create";
        URI url = URI.create(finalUrl);
        // Create Request Entity
        RequestEntity req = RequestEntity.post(url).body(createUserRB);
        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, req, String.class);
        }catch (Exception e){
            throw new DatabaseInsertionException(e.getMessage());
        }
    }

    public AppUser getUserByEmail(String email){

        String url = dbApiUrl + "/user/email/" + email;
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<AppUser> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, AppUser.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }

    public AppUser getUserById(UUID id){

        String url = dbApiUrl + "/user/" + id.toString();
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<AppUser> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, AppUser.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }

    public Threater createThreater(Threater threater){
        // Calling DB API to save user
        String finalUrl = dbApiUrl + "/threater/create";
        URI url = URI.create(finalUrl);
        // Create Request Entity
        RequestEntity req = RequestEntity.post(url).body(threater);
        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Threater> response = restTemplate.exchange(url, HttpMethod.POST, req, Threater.class);
            return response.getBody();
        }catch (Exception e){
            throw new DatabaseInsertionException(e.getMessage());
        }
    }

    public Threater getTheaterById(UUID theaterId){
        String url = dbApiUrl + "/threater/" + theaterId.toString();
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(finalUrl).build();

        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<Threater> resp  = restTemplate.exchange(url, HttpMethod.GET, request, Threater.class);
            return resp.getBody();
        }catch (Exception e){
            throw e;
        }
    }

    public Hall createHall(Hall hall){
        // 1. Create your URL
        String url = dbApiUrl + "/threater/hall/create";
        URI finalUrl = URI.create(url);
        // 2. Create request entity
        RequestEntity request = RequestEntity.post(finalUrl).body(hall);
        // 3. Hit the request
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Hall> resp = restTemplate.exchange(finalUrl, HttpMethod.POST, request, Hall.class);
            return resp.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
