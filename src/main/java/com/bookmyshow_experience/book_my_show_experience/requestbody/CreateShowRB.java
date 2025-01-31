package com.bookmyshow_experience.book_my_show_experience.requestbody;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class CreateShowRB {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime endTime;
    String movieName;

    public CreateShowRB(LocalDateTime startTime, LocalDateTime endTime, String movieName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movieName = movieName;
    }

    public CreateShowRB() {
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
