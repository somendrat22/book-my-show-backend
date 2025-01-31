package com.bookmyshow_db.book_my_show_db.controller;

import com.bookmyshow_db.book_my_show_db.models.Hall;
import com.bookmyshow_db.book_my_show_db.models.Show;
import com.bookmyshow_db.book_my_show_db.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/hall")
public class HallController {

    @Autowired
    HallRepository hallRepository;

    @GetMapping("/{hallId}")
    public Hall getHallById(@PathVariable UUID hallId){
        return hallRepository.findById(hallId).orElse(null);
    }


}
