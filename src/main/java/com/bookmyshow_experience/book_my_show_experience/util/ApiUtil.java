package com.bookmyshow_experience.book_my_show_experience.util;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.exceptions.DatabaseInsertionException;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class ApiUtil {


    public Object makePutCall(String apiUrl, Object requestBody, String endPoint ){
        String finalUrl = apiUrl + endPoint;
        URI url = URI.create(finalUrl);
        // Create Request Entity
        RequestEntity req = RequestEntity.put(url).body(requestBody);
        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, req, Object.class);
            return response.getBody();
        }catch (Exception e){
            throw new DatabaseInsertionException(e.getMessage());
        }
    }

    public Object makePostCall(String apiUrl, Object requestBody, String endPoint){
        String finalUrl = apiUrl + endPoint;
        URI url = URI.create(finalUrl);
        // Create Request Entity
        RequestEntity req = RequestEntity.post(url).body(requestBody);
        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, req, Object.class);
            return response.getBody();
        }catch (Exception e){
            throw new DatabaseInsertionException(e.getMessage());
        }
    }

    public Object makeGetCall(String apiUrl, String endPoint){
        String url = apiUrl + endPoint;
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.get(finalUrl).build();

        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<Object> resp  = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
            return resp.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
