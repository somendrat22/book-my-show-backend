package com.bookmyshow_mail.book_my_show_mail.requestbody;






















public class Booking {
    String userName;
    String userEmail;
    int totalTickets;
    int totalAmountPaid;
    String paymentMethod;
    String hallName;
    String theaterName;
    String theaterAddress;

    public Booking(String userName, String userEmail, int totalTickets, int totalAmountPaid, String paymentMethod, String hallName, String theaterName, String theaterAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.totalTickets = totalTickets;
        this.totalAmountPaid = totalAmountPaid;
        this.paymentMethod = paymentMethod;
        this.hallName = hallName;
        this.theaterName = theaterName;
        this.theaterAddress = theaterAddress;
    }

    public Booking() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(int totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }
}
