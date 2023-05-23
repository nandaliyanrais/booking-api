package com.rais.bookingapi.movieslot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Movie Studio not found")
public class MovieSlotNotFoundException extends RuntimeException {

    public MovieSlotNotFoundException() {
        
    }

    public MovieSlotNotFoundException(String message) {
        super(message);
    }
    
}
