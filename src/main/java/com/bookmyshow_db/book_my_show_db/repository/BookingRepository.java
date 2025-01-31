package com.bookmyshow_db.book_my_show_db.repository;

import com.bookmyshow_db.book_my_show_db.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
