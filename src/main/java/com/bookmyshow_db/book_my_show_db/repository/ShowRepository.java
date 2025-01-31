package com.bookmyshow_db.book_my_show_db.repository;

import com.bookmyshow_db.book_my_show_db.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {
}
