package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Booking;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateBookingRB;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRB;
import com.bookmyshow_experience.book_my_show_experience.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exp/ticket")
public class TicketController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public Booking bookTicket(@RequestBody CreateBookingRB bookingRB){
        Booking booking = bookingService.bookTicket(bookingRB);
        return booking;
    }
}
