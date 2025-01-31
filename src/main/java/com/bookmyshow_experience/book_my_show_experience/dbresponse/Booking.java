package com.bookmyshow_experience.book_my_show_experience.dbresponse;

import java.util.UUID;

public class Booking {
    UUID id;

    AppUser user;
    int totalSeats;

    Show show;
    String paymentMethod;
    int totalAmount;

    public Booking(UUID id, AppUser user, int totalSeats, Show show, String paymentMethod, int totalAmount) {
        this.id = id;
        this.user = user;
        this.totalSeats = totalSeats;
        this.show = show;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }

    public Booking() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
