package com.bookmyshow_experience.book_my_show_experience.requestbody;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;

import java.util.UUID;

public class CreateHallRB {


        int seats;


    public CreateHallRB() {
    }

    public CreateHallRB(int seats) {


        this.seats = seats;
    }





        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }
    }

