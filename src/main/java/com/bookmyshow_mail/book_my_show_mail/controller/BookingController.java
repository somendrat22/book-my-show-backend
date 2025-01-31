package com.bookmyshow_mail.book_my_show_mail.controller;

import com.bookmyshow_mail.book_my_show_mail.requestbody.Booking;
import com.bookmyshow_mail.book_my_show_mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/mail/booking")
public class BookingController {

    @Autowired
    MailUtility mailUtility;


    @PutMapping("/create")
    public void sendBookingMail(@RequestBody Booking booking) throws Exception{
        mailUtility.sendBookingMail(booking);
    }
}
