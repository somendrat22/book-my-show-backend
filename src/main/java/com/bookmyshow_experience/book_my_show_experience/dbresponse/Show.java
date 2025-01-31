package com.bookmyshow_experience.book_my_show_experience.dbresponse;



import java.util.UUID;


public class Show implements Comparable<Show>{

    UUID id;
    Long startTime;
    Long endTime;

    String movieName;



    int ticketPrice;

    int totalTickets;

    Hall hall;
    int ticketsSold;

    public Show(UUID id, Long startTime, Long endTime, Hall hall, int ticketsSold, String movieName,
                int ticketPrice,
                int totalTickets) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.ticketsSold = ticketsSold;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.totalTickets = totalTickets;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Show() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
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

    public int compareTo(Show obj){
        return (int)(this.startTime - obj.endTime);
    }
}

