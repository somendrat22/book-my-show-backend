package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.DTOs.OwnerDto;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
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

    public OwnerDto getUserById(UUID id){

        String url = dbApiUrl + "/user/" + id.toString();
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<OwnerDto> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, OwnerDto.class);

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

    public Threater getThreaterById(UUID theaterId){

        String url = dbApiUrl + "/threater/" + theaterId.toString();
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Threater> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, Threater.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }
    public Hall createHall(Hall hall){
        // Calling DB API to save user
        String finalUrl = dbApiUrl + "/threater/hall/create";
        URI url = URI.create(finalUrl);
        // Create Request Entity
        RequestEntity req = RequestEntity.post(url).body(hall);
        // Create RestTemplate for hitting request
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Hall> response = restTemplate.exchange(url, HttpMethod.POST, req, Hall.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }


}
