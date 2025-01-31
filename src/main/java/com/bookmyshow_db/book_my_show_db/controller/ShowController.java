package com.bookmyshow_db.book_my_show_db.controller;

import com.bookmyshow_db.book_my_show_db.models.Show;
import com.bookmyshow_db.book_my_show_db.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/show")
public class ShowController {

    @Autowired
    ShowRepository showRepository;

    @PostMapping("/create")
    public ResponseEntity createShow(@RequestBody Show show){
        showRepository.save(show);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    @GetMapping("/{showId}")
    public Show getShowById(@PathVariable UUID showId){
        return showRepository.findById(showId).orElse(null);
    }
}
