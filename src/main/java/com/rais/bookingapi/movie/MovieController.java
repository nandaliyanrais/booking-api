package com.rais.bookingapi.movie;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rais.bookingapi.movie.models.Image;
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
    private final ImageService imageService;

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

    @GetMapping("/movies/{id}/images")
    public ResponseEntity<byte[]> getOneImageByMovie(@PathVariable("id") Long id) throws IOException {
        Movie existingMovie = this.movieService.findOneById(id);
        Image image = existingMovie.getImage();
        Resource resource = this.imageService.load(image);

        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getType())).body(resource.getContentAsByteArray());
    }

    // @PostMapping("/movies")
    // @EnableCallLogging
    // public ResponseEntity<MovieCreateResponse> createOne(@Valid @RequestBody MovieRequest movieRequest) {
    //     if (movieRequest.getTitle().isBlank()) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    //     }

    //     Movie newMovie = movieRequest.convertToEntity();
    //     Movie saveMovie = this.movieService.createOne(newMovie);
    //     MovieCreateResponse movieResponse = saveMovie.convertToMovieCreateResponse();
        
    //     return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    // }

    @PostMapping(value = "/movies", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<MovieCreateResponse> createOne(@Valid @RequestPart("movieRequest") MovieRequest movieRequest, @RequestPart("image") MultipartFile imageFile) {
        if (movieRequest.getTitle().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String url = this.imageService.save(imageFile);
        Movie newMovie = movieRequest.convertToEntity();
        Image image = Image.builder().name(imageFile.getOriginalFilename()).type(imageFile.getContentType()).url(url).build();
        newMovie.setImage(image);
        Movie saveMovie = this.movieService.createOne(newMovie);
        MovieCreateResponse movieResponse = saveMovie.convertToMovieCreateResponse();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

}
