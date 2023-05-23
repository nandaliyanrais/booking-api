package com.rais.bookingapi.movieslot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.movieslot.models.MovieSlot;

public interface MovieSlotRepository extends JpaRepository<MovieSlot, Long> {

    // findbystudio
    // notexist
}
