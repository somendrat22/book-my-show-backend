package com.bookmyshow_mail.book_my_show_mail.requestbody;



import java.util.UUID;

public class AppUser {

    UUID id;
    String name;

    String email;

    String password;

    Long contactNumber;
    String userType;

    public AppUser() {
    }

    public AppUser(UUID id, String name, String email, String password, Long contactNumber, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}


