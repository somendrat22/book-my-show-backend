package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.exceptions.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.exceptions.TheaterNotFound;
import com.bookmyshow_experience.book_my_show_experience.exceptions.UnAuthorized;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRB;
import com.bookmyshow_experience.book_my_show_experience.service.ThreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/exp/theater")
public class ThreaterController {

    @Autowired
    ThreaterService threaterService;

    @PostMapping("/create")
    public ResponseEntity createThreater(@RequestBody CreateThreaterRB createThreaterRB,
                                         @RequestParam UUID ownerUserId
                                         ){

        // Request Body -> Threater details
        // Request Param -> ownerUserID
        try{
            Threater threater = threaterService.createThreater(createThreaterRB, ownerUserId);
            return new ResponseEntity(threater, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hall/create")
    public ResponseEntity createHall(@RequestParam UUID ownerID,
                           @RequestParam UUID theaterID,
                           @RequestParam int hallSeats){
        try{
            Hall hall = threaterService.createHallForTheater(theaterID,ownerID, hallSeats);
            return new ResponseEntity(hall, HttpStatus.CREATED);
        }catch (InvalidUser e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (UnAuthorized e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (TheaterNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/hall/create")
    public ResponseEntity createHall(@RequestParam UUID ownerID, @RequestParam UUID
            theaterID,@RequestParam int hallSeats){
        try{
            Hall hall = threaterService.createHall(theaterID,ownerID,hallSeats);
            return new ResponseEntity(hall, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
