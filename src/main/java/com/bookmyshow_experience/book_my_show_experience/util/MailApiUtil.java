package com.bookmyshow_experience.book_my_show_experience.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MailApiUtil {

    @Value("${mail.api.url}")
    String mailApiURl;
    public void sendUserRegistrationMail(String userEmail, String userName){
        String url = mailApiURl + "/user/register" + "?email=" + userEmail + "&userName=" + userName;
        URI finalUrl = URI.create(url);
        RequestEntity req = RequestEntity.put(finalUrl).build();
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, req, String.class);
        }catch (Exception e){
            throw e;
        }
    }
}
