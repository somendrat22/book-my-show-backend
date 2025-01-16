package com.bookmyshow_mail.book_my_show_mail.controller;

import com.bookmyshow_mail.book_my_show_mail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail/user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PutMapping("/register")
    public ResponseEntity sendUserRegistrationMail(@RequestParam String email,
                                                   @RequestParam String userName){

        try{
            userService.sendUserRegistrationMail(email, userName);
            return new ResponseEntity("Mail sent successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
