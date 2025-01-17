package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.exceptions.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRB;
import com.bookmyshow_experience.book_my_show_experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreaterService {

    @Autowired
    DatabaseAPIUtil databaseAPI;

    @Autowired
    MailApiUtil mailApiUtil;
    @Autowired
    EntityMapper entityMapper;

    public Threater createThreater(CreateThreaterRB createThreaterRB, UUID ownerUserID){
        // Is userID exist in system not
        // if userID exists then we need to verify type of user
        // Call DB API to provide user object on the basis of userID we are passing
        AppUser user = databaseAPI.getUserById(ownerUserID);
        if(!user.getUserType().equals("ThreaterOwner")){
            // Exception throw
            throw new InvalidUser(String.format("User with id %s does not have access to create Threater", ownerUserID.toString()));
        }
        // If you don't come inside if condition that means user is a threater owner
        // experience api will call database api to create threater in database
        Threater threater = entityMapper.convertThreaterRBToThreaterModel(createThreaterRB, user);
        Threater respThreater = databaseAPI.createThreater(threater);
        // call mail api to notify owner that his threater got registered

        mailApiUtil.sendThreaterRegistrationMail(threater);

        return respThreater;
    }
}
