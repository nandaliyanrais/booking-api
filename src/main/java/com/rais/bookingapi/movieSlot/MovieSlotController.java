package com.rais.bookingapi.movieslot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.movieslot.models.MovieSlot;
import com.rais.bookingapi.movieslot.models.dto.response.MovieSlotResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovieSlotController {

    private final MovieSlotService movieStudioService;

    @GetMapping("/movie-studios")
    public ResponseEntity<List<MovieSlotResponse>> getAll() {
        List<MovieSlot> movieStudios = movieStudioService.getAll();
        List<MovieSlotResponse > movieStudioResponses = movieStudios.stream().map(movieStudio -> movieStudio.convertToResponse()).toList();

        return ResponseEntity.status(HttpStatus.OK).body(movieStudioResponses);
    }

    @GetMapping("/movie-studios/{id}")
    public ResponseEntity<MovieSlotResponse> getOneMovie(@PathVariable("id") Long id) {
        MovieSlot existingMovieStudio = this.movieStudioService.findOneById(id);
        MovieSlotResponse movieStudioResponse = existingMovieStudio.convertToResponse();

        return ResponseEntity.status(HttpStatus.OK).body(movieStudioResponse);
    }

}
