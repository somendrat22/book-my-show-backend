package com.bookmyshow_experience.book_my_show_experience.dbresponse;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;

import java.util.UUID;

@Builder
public class Threater {

    UUID id;

    AppUser owner;
    String address;

    Long threaterHelpLine;

    public Threater() {
    }

    public Threater(UUID id, AppUser owner, String address, Long threaterHelpLine) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.threaterHelpLine = threaterHelpLine;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getThreaterHelpLine() {
        return threaterHelpLine;
    }

    public void setThreaterHelpLine(Long threaterHelpLine) {
        this.threaterHelpLine = threaterHelpLine;
    }
}
