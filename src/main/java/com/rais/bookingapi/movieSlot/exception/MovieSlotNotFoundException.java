package com.rais.bookingapi.movieSlot.exception;

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
