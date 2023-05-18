package com.rais.bookingapi.seat;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.seat.models.Seat;
import com.rais.bookingapi.seat.models.dto.SeatRequest;
import com.rais.bookingapi.seat.models.dto.SeatResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping("movie-slots/{movieSlotId}/seats")
    public ResponseEntity<List<SeatResponse>> getAll() {
        List<Seat> seats = seatService.getAll();
        List<SeatResponse> seatResponses = seats.stream().map(seat -> seat.convertToResponse()).toList();
        return ResponseEntity.ok(seatResponses);
    }

    @PostMapping("movie-slots/{movieSlotId}/seats")
    public ResponseEntity<SeatResponse> createOne(@Valid @RequestBody SeatRequest seatRequest) {
        Seat newSeat = seatRequest.convertToEntity();
        Seat saveSeat = this.seatService.createOne(newSeat);
        SeatResponse seatResponse = saveSeat.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(seatResponse);
    }
    
}
