package com.bookmyshow_experience.book_my_show_experience.exceptions;

public class UnAuthorized extends RuntimeException{
    public UnAuthorized(String message){
        super(message);
    }
}
