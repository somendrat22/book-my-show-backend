package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.exceptions.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import com.bookmyshow_experience.book_my_show_experience.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exp/user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody CreateUserRB createUserRB){
        try{
            userService.createUser(createUserRB);
            return new ResponseEntity("User created successfully",
                    HttpStatus.CREATED);
        }catch (DatabaseInsertionException databaseInsertionException){
            return new ResponseEntity<>(databaseInsertionException.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
