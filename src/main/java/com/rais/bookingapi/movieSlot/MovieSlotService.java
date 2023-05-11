package com.rais.bookingapi.movieSlot;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rais.bookingapi.movieSlot.exception.MovieSlotNotFoundException;
import com.rais.bookingapi.movieSlot.models.MovieSlot;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieSlotService {

    private final MovieSlotRepository movieStudioRepository;

    public List<MovieSlot> getAll() {
        return this.movieStudioRepository.findAll();
    }

    public MovieSlot findOneById(Long id) {
        return this.movieStudioRepository.findById(id).orElseThrow(() -> new MovieSlotNotFoundException());
    }

}
