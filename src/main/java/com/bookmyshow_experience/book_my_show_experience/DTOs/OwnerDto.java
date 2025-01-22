package com.bookmyshow_experience.book_my_show_experience.DTOs;

import java.util.UUID;

public class OwnerDto {
    UUID id;
    String name;
    Long contactNumber;
    String userType;

    public OwnerDto() {
    }

    public OwnerDto(UUID id, String name, Long contactNumber, String userType) {
        this.id = id;
        this.name = name;
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
