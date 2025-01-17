package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRB;
import com.bookmyshow_experience.book_my_show_experience.service.ThreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/exp/threater")
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
}
