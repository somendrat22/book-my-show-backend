package com.bookmyshow_db.book_my_show_db.repository;

import com.bookmyshow_db.book_my_show_db.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {
}
