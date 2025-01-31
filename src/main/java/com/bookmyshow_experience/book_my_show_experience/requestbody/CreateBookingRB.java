package com.bookmyshow_experience.book_my_show_experience.requestbody;

import com.bookmyshow_experience.book_my_show_experience.enums.PaymentMethod;

import java.util.UUID;

public class CreateBookingRB {
    UUID userId;
    UUID showId;
    int totalSeats;
    PaymentMethod paymentMode;

    public CreateBookingRB(UUID userId, UUID showId, int totalSeats, PaymentMethod paymentMode) {
        this.userId = userId;
        this.showId = showId;
        this.totalSeats = totalSeats;
        this.paymentMode = paymentMode;
    }

    public CreateBookingRB() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getShowId() {
        return showId;
    }

    public void setShowId(UUID showId) {
        this.showId = showId;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public PaymentMethod getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMethod paymentMode) {
        this.paymentMode = paymentMode;
    }
}
