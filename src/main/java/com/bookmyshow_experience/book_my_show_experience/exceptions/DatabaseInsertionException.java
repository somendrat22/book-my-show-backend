package com.bookmyshow_experience.book_my_show_experience.exceptions;

public class DatabaseInsertionException extends RuntimeException{
    public DatabaseInsertionException(String message){
        super(message);
    }
}
