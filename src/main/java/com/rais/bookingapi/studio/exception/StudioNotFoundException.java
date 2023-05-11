package com.rais.bookingapi.studio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Studio not found")
public class StudioNotFoundException extends RuntimeException {

    public StudioNotFoundException() {
        
    }

    public StudioNotFoundException(String message) {
        super(message);
    }

}
