package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.enums.UserType;
import com.bookmyshow_experience.book_my_show_experience.exceptions.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.exceptions.TheaterNotFound;
import com.bookmyshow_experience.book_my_show_experience.exceptions.UnAuthorized;
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


    public Hall createHallForTheater(UUID theaterId, UUID ownerId, int hallSeats){
        // Verify user exist in system or not
        // if user exists then check type of the user
        AppUser user = databaseAPI.getUserById(ownerId);
        if(user == null){
            throw new InvalidUser(String.format("User with id %s does not exist in system", ownerId.toString()));
        }
        if(!user.getUserType().equals(UserType.ThreaterOwner.toString())){
            throw new UnAuthorized(String.format("User with id %s does not have access to create halls", ownerId.toString()));
        }

        // call database api to create hall in the database
        Hall hall = new Hall();
        try{
            // To create hall object we need 2 things hallSeats and Theater object
            // Experience api has theaterID
            // We need to develop getTHreaterBYId endpoint in database api such that we can get theater object
            Threater theater = databaseAPI.getTheaterById(theaterId);
            if(theater == null){
                throw new TheaterNotFound(String.format("Theater with id %s does not exist in system.", theaterId.toString()));
            }
            if(!theater.getOwner().getId().equals(ownerId)){
                throw new UnAuthorized(String.format("User with id %s does not have access to create hall in theater with id %s", ownerId.toString(), theaterId.toString()));
            }
            hall.setThreater(theater);
            hall.setSeats(hallSeats);
            hall = databaseAPI.createHall(hall);
        }catch (Exception e){
            throw e;
        }

        // Mail API -> Notify hall owner that his hall is created for his theater

        try {
            mailApiUtil.sendHallRegistrationMail(hall);
        }catch (Exception e){
            throw e;
        }

        return hall;

    }
}
