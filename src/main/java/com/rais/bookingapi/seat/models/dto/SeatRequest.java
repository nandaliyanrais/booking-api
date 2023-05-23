package com.rais.bookingapi.seat.models.dto;

import com.rais.bookingapi.customeruser.models.CustomerUser;
import com.rais.bookingapi.movieslot.models.MovieSlot;
import com.rais.bookingapi.seat.models.Seat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    
    private Long id;

    private String seatNumber;

    private CustomerUser customerUser;

    private MovieSlot movieSlot;

    public Seat convertToEntity() {
        return Seat.builder()
                .id(this.id)
                .seatNumber(this.seatNumber)
                .customerUser(this.customerUser)
                .movieSlot(this.movieSlot)
                .build();
    }
}
