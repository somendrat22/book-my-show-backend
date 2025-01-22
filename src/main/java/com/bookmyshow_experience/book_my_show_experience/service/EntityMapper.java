package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.DTOs.OwnerDto;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateHallRB;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRB;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {



    public Threater convertThreaterRBToThreaterModel(CreateThreaterRB createThreaterRB, OwnerDto owner) {
        Threater threater = new Threater();
        threater.setOwner(owner);
        threater.setAddress(createThreaterRB.getAddress());
        threater.setThreaterHelpLine(createThreaterRB.getHelpLineNumber());
        return threater;
    }
    public Hall convertHallRBToHallModel(CreateHallRB createHallRB, Threater threater) {
        Hall hall = new Hall();
        hall.setSeats(hall.getSeats());

        return hall;
    }

}
