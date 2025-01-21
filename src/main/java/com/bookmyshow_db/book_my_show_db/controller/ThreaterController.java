package com.bookmyshow_db.book_my_show_db.controller;

import com.bookmyshow_db.book_my_show_db.models.Hall;
import com.bookmyshow_db.book_my_show_db.models.Threater;
import com.bookmyshow_db.book_my_show_db.repository.HallRepository;
import com.bookmyshow_db.book_my_show_db.repository.ThreaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/threater")
public class ThreaterController {

    ThreaterRepository threaterRepository;
    HallRepository hallRepository;

    @Autowired
    public ThreaterController(ThreaterRepository threaterRepository, HallRepository hallRepository){
        this.threaterRepository = threaterRepository;
        this.hallRepository = hallRepository;
    }

    @PostMapping("/create")
    public ResponseEntity createThreater(@RequestBody Threater threater){
        threaterRepository.save(threater);
        return new ResponseEntity(threater, HttpStatus.CREATED);
    }

    @PostMapping("/hall/create")
    public ResponseEntity createHall(@RequestBody Hall hall){
        hallRepository.save(hall);
        return new ResponseEntity(hall, HttpStatus.CREATED);
    }

    @GetMapping("/{theaterId}")
    public ResponseEntity getTheaterById(@PathVariable UUID theaterId){
        Threater theater = threaterRepository.findById(theaterId).orElse(null);
        return new ResponseEntity(theater, HttpStatus.OK);
    }
}
