package com.rais.bookingapi.seat.models.dto;

import com.rais.bookingapi.customerUser.models.CustomerUser;
import com.rais.bookingapi.movieSlot.models.MovieSlot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse {

    private Long id;
    private String seatNumber;
    private CustomerUser customerUser;
    private MovieSlot movieSlot;
    
}
