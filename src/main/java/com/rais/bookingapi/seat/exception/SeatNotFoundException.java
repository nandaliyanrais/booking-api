package com.rais.bookingapi.seat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Seat not found")
public class SeatNotFoundException extends RuntimeException {

    public SeatNotFoundException() {
        
    }

    public SeatNotFoundException(String message) {
        super(message);
    }

}
