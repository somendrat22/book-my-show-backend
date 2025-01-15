package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    UserService(DatabaseAPIUtil databaseAPIUtil){
        this.databaseAPIUtil = databaseAPIUtil;
    }

    public void createUser(CreateUserRB createUserRB){
        databaseAPIUtil.createUser(createUserRB);
    }
}
