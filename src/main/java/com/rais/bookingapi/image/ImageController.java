package com.rais.bookingapi.image;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.image.models.Image;
import com.rais.bookingapi.movie.MovieService;
import com.rais.bookingapi.movie.models.Movie;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final MovieService movieService;
    private final ImageService imageService;

    @GetMapping("/movies/{id}/images")
    public ResponseEntity<byte[]> getOneImageByMovie(@PathVariable("id") Long id) throws IOException {
        Movie existingMovie = this.movieService.findOneById(id);
        Image image = existingMovie.getImage();
        Resource resource = this.imageService.load(image);

        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getType())).body(resource.getContentAsByteArray());
    }
    
}
