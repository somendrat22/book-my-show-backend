package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRB;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {

    public Threater convertThreaterRBToThreaterModel(CreateThreaterRB createThreaterRB, AppUser owner) {
        Threater threater = new Threater();
        threater.setOwner(owner);
        threater.setAddress(createThreaterRB.getAddress());
        threater.setThreaterHelpLine(createThreaterRB.getHelpLineNumber());
        return threater;
    }

}
