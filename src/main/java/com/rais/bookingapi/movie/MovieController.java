package com.rais.bookingapi.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.common.EnableCallLogging;
import com.rais.bookingapi.movie.models.Movie;
import com.rais.bookingapi.movie.models.dto.request.MovieRequest;
import com.rais.bookingapi.movie.models.dto.response.MovieCreateResponse;
import com.rais.bookingapi.movie.models.dto.response.MovieResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponse>> getAll(@RequestParam(value = "title") Optional<String> optionalTitle) {
        List<Movie> movies = movieService.getAll(optionalTitle);
        List<MovieResponse> movieResponses = movies.stream().map(movie -> movie.convertToResponse()).toList();

        return ResponseEntity.status(HttpStatus.OK).body(movieResponses);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieResponse> getOneMovie(@PathVariable("id") Long id) {
        Movie existingMovie = this.movieService.findOneById(id);
        MovieResponse movieResponse = existingMovie.convertToResponse();

        return ResponseEntity.ok(movieResponse);
    }

    @PostMapping("/movies")
    @EnableCallLogging
    public ResponseEntity<MovieCreateResponse> createOne(@Valid @RequestBody MovieRequest movieRequest) {
        if (movieRequest.getTitle().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Movie newMovie = movieRequest.convertToEntity();
        Movie saveMovie = this.movieService.createOne(newMovie);
        MovieCreateResponse movieResponse = saveMovie.convertToMovieCreateResponse();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

}
