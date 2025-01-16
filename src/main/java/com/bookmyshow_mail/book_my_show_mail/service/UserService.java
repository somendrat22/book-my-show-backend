package com.bookmyshow_mail.book_my_show_mail.service;

import com.bookmyshow_mail.book_my_show_mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    MailUtility mailUtility;

    @Autowired
    UserService(MailUtility mailUtility){
        this.mailUtility = mailUtility;
    }

    public void sendUserRegistrationMail(String email, String userName) throws Exception{
        mailUtility.sendMail("Welcome to Book My Show !!",
                "user-registration",
                email,
                userName);
    }
}
