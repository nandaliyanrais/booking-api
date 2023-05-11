package com.rais.bookingapi.movieSlot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.movieSlot.models.MovieSlot;

public interface MovieSlotRepository extends JpaRepository<MovieSlot, Long> {

    // findbystudio
    // notexist
}
