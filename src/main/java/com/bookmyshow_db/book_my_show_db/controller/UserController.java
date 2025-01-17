package com.bookmyshow_db.book_my_show_db.controller;

import com.bookmyshow_db.book_my_show_db.models.AppUser;
import com.bookmyshow_db.book_my_show_db.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class UserController {

    AppUserRepository appUserRepository;


    @Autowired
    UserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return new ResponseEntity("User got saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{userID}")
    public ResponseEntity getUserByID(@PathVariable UUID userID){
        AppUser user = appUserRepository.findById(userID).orElse(null);
        if(user == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(user, HttpStatus.OK);
        }
    }
}
