package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.*;
import com.bookmyshow_experience.book_my_show_experience.exceptions.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import com.bookmyshow_experience.book_my_show_experience.util.ApiUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.UUID;

@Service
public class DatabaseAPIUtil extends ApiUtil {

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


    public Show createShow(Show show){
        Object resp  = makePostCall(dbApiUrl, show, "/show/create");
        ModelMapper mapper = new ModelMapper();
        Show showResp = mapper.map(resp, Show.class);
        return showResp;
    }

    public Hall getHallById(UUID hallId){
        String endPoint = "/hall/" + hallId.toString();
        Object resp = makeGetCall(dbApiUrl, endPoint);
        ModelMapper mapper = new ModelMapper();
        Hall hall = mapper.map(resp, Hall.class);
        return hall;
    }

    public List<Show> getAllShows(){
        String endPoint = "/show/all";
        ModelMapper mapper = new ModelMapper();
        Type listType = new TypeToken<List<Show>>(){}.getType();
        Object resp = makeGetCall(dbApiUrl, endPoint);
        List<Show> shows = mapper.map(resp, listType);
        return shows;
    }

    public Show getShowById(UUID showId){
        String endPoint = "/show/" + showId.toString();
        Object resp = makeGetCall(dbApiUrl, endPoint);
        ModelMapper mapper = new ModelMapper();
        Show show = mapper.map(resp, Show.class);
        return show;
    }

    public void createBooking(Booking booking){
        String endPoint = "/booking/create";
        makePostCall(dbApiUrl, booking, endPoint);
    }

}
