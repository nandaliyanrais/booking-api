package com.rais.bookingapi.seat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.seat.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    
}
