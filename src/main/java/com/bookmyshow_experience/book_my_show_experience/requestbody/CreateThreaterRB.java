package com.bookmyshow_experience.book_my_show_experience.requestbody;

public class CreateThreaterRB {
    Long helpLineNumber;
    String address;

    public CreateThreaterRB(Long helpLineNumber, String address) {
        this.helpLineNumber = helpLineNumber;
        this.address = address;
    }

    public CreateThreaterRB() {
    }

    public Long getHelpLineNumber() {
        return helpLineNumber;
    }

    public void setHelpLineNumber(Long helpLineNumber) {
        this.helpLineNumber = helpLineNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
