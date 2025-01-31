package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.exceptions.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;

import com.bookmyshow_experience.book_my_show_experience.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exp/user")
public class UserController {

    public class UserJwtResponse{
        String token;
    }

    UserService userService;


    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody CreateUserRB createUserRB){
        try{
            userService.createUser(createUserRB);
            String credentials = createUserRB.getEmail() + ":" + createUserRB.getPassword();

            return new ResponseEntity("Successfull",
                    HttpStatus.CREATED);
        }catch (DatabaseInsertionException databaseInsertionException){
            return new ResponseEntity<>(databaseInsertionException.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
