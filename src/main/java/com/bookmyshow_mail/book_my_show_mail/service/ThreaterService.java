package com.bookmyshow_mail.book_my_show_mail.service;

import com.bookmyshow_mail.book_my_show_mail.requestbody.Hall;
import com.bookmyshow_mail.book_my_show_mail.requestbody.Threater;
import com.bookmyshow_mail.book_my_show_mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreaterService {

    @Autowired
    MailUtility mailUtility;

    public void sendThreaterRegistrationMail(Threater threater) throws Exception{
        String toEmail = threater.getOwner().getEmail();
        String address = threater.getAddress();
        String subjectLine = "Theater Registration Successful!";
        mailUtility.sendThreaterRegistrationMail(
             toEmail,
             threater.getOwner().getName(),
             address,
             subjectLine
        );
    }

    public void sendHallRegistrationMail(Hall hall) throws Exception{
        String ownerEmail = hall.getThreater().getOwner().getEmail();
        String ownerName = hall.getThreater().getOwner().getName();
        String theaterLocation = hall.getThreater().getAddress();
        int seats = hall.getSeats();
        String subjectLine = "Hall Registration Successful!";
        mailUtility.sendHallRegistrationMail(ownerEmail, ownerName, theaterLocation, seats, subjectLine);
    }
}
