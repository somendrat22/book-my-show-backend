package com.bookmyshow_experience.book_my_show_experience.util;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Booking;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Hall;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.requestbody.BookingRequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MailApiUtil extends ApiUtil{

    @Value("${mail.api.url}")
    String mailApiURl;
    public void sendUserRegistrationMail(String userEmail, String userName){
        String url = mailApiURl + "/user/register" + "?email=" + userEmail + "&userName=" + userName;
        URI finalUrl = URI.create(url);
        RequestEntity req = RequestEntity.put(finalUrl).build();
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, req, String.class);
        }catch (Exception e){
            throw e;
        }
    }

    public void sendThreaterRegistrationMail(Threater threater){
        String url = mailApiURl + "/threater/create";
        URI finalUrl = URI.create(url);
        RequestEntity req = RequestEntity.put(finalUrl).body(threater);
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, req, String.class);
        }catch (Exception e){
            throw e;
        }
    }

    public void sendHallRegistrationMail(Hall hall){
        String url = mailApiURl + "/threater/hall/create";
        URI finalUrl = URI.create(url);
        RequestEntity req = RequestEntity.put(finalUrl).body(hall);
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, req, String.class);
        }catch (Exception e){
            throw e;
        }
    }

    public void sendBookingMail(Booking booking){
        BookingRequestBody bookingRequestBody = new BookingRequestBody();
        bookingRequestBody.setHallName("A");
        bookingRequestBody.setPaymentMethod(booking.getPaymentMethod());
        bookingRequestBody.setTotalTickets(booking.getTotalSeats());
        bookingRequestBody.setUserEmail(booking.getUser().getEmail());
        bookingRequestBody.setTheaterName("A");
        bookingRequestBody.setTotalAmountPaid(booking.getTotalAmount());
        bookingRequestBody.setTheaterAddress(booking.getShow().getHall().getThreater().getAddress());
        bookingRequestBody.setUserName(booking.getUser().getName());

        makePutCall(mailApiURl, bookingRequestBody, "/booking/create");

    }
}
