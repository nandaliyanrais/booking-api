package com.rais.bookingapi.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Movie not found")
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {

    }

    public MovieNotFoundException(String message) {
        super(message);
    }
    
}
