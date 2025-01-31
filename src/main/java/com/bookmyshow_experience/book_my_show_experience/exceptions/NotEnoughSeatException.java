package com.bookmyshow_experience.book_my_show_experience.exceptions;

public class NotEnoughSeatException extends RuntimeException{
    public NotEnoughSeatException(String message){
        super(message);
    }
}
