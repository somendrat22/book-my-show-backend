package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import com.bookmyshow_experience.book_my_show_experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    DatabaseAPIUtil databaseAPIUtil;
    MailApiUtil mailApiUtil;
    @Autowired
    UserService(DatabaseAPIUtil databaseAPIUtil,
                MailApiUtil mailApiUtil){
        this.mailApiUtil = mailApiUtil;
        this.databaseAPIUtil = databaseAPIUtil;
    }

    public void createUser(CreateUserRB createUserRB){
        try{
            databaseAPIUtil.createUser(createUserRB);
        }catch (Exception e){
            throw e;
        }
        try{
            mailApiUtil.sendUserRegistrationMail(createUserRB.getEmail(), createUserRB.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
