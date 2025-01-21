package com.bookmyshow_db.book_my_show_db.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    Double startTime;
    Double endTime;
    @ManyToOne
    Hall hall;
    int ticketsSold;

    public Show(UUID id, Double startTime, Double endTime, Hall hall, int ticketsSold) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.ticketsSold = ticketsSold;
    }

    public Show() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
}
