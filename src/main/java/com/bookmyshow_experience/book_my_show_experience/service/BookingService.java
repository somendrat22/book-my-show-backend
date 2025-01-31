package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Booking;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Show;
import com.bookmyshow_experience.book_my_show_experience.exceptions.NotEnoughSeatException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateBookingRB;
import com.bookmyshow_experience.book_my_show_experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    MailApiUtil mailApiUtil;

    public Booking bookTicket(CreateBookingRB bookingDetails){
        UUID userID = bookingDetails.getUserId();
        UUID showId = bookingDetails.getShowId();
        int ticketCount = bookingDetails.getTotalSeats();
        String paymentMode = bookingDetails.getPaymentMode().toString();


        // call Database to createbooking
        AppUser user = databaseAPIUtil.getUserById(userID);
        Show show = databaseAPIUtil.getShowById(showId);

        int leftTicket =  show.getTotalTickets() - ticketCount;



        show.setTotalTickets(leftTicket);
        show.setTicketsSold(show.getTicketsSold() + ticketCount);

        Booking booking = new Booking();
        booking.setShow(show);
        booking.setUser(user);
        booking.setPaymentMethod(paymentMode);
        booking.setTotalAmount(ticketCount*show.getTicketPrice());

        // database api make post call

        databaseAPIUtil.createBooking(booking);
        mailApiUtil.sendBookingMail(booking);
        return booking;

    }
}
