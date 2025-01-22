package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.DTOs.OwnerDto;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.enums.UserType;
import com.bookmyshow_experience.book_my_show_experience.exceptions.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.exceptions.TheaterNotFound;
import com.bookmyshow_experience.book_my_show_experience.exceptions.UnAuthorised;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateHallRB;
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
        OwnerDto user = databaseAPI.getUserById(ownerUserID);
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

    public Hall createHall(UUID theaterId,UUID ownerId,int hallSeats){
        // Is userID exist in system not
        // if userID exists then we need to verify type of user
        // Call DB API to provide user object on the basis of userID we are passing
        OwnerDto user = databaseAPI.getUserById(ownerId);
        if(user==null){
            // Exception throw
            throw new InvalidUser(String.format("User with id %s does not have access to create Hall", ownerId.toString()));
        }
        if(!user.getUserType().equals("ThreaterOwner"))
            throw new UnAuthorised(String.format("User with id %s does not have access to create halls", ownerId.toString()));

        // If you don't come inside if condition that means user is a threater owner
        //crate hall by calling db api
        // call mail api to notify owner that his threater got registered
        Hall hall = new Hall();
        try{
               Threater theater=databaseAPI.getThreaterById(theaterId);
               if(theater==null){
                   throw new TheaterNotFound(String.format("Theater with id %s does not exist in system.",theaterId.toString()));
               }
               if(!theater.getOwner().getId().equals(ownerId)){
                   throw new UnAuthorised(String.format("User with id %s does not have access to create hall in theater with id %s", ownerId.toString(), theaterId.toString()));
               }
               hall.setThreater(theater);
               hall.setSeats(hallSeats);
               hall=databaseAPI.createHall(hall);
           }catch(Exception e){
            throw e;
        }
        try {
            mailApiUtil.sendHallRegistrationMail(hall);
        }catch (Exception e){
            throw e;
        }

        return hall;
    }
}
