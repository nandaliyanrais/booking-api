package com.rais.bookingapi.seat;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rais.bookingapi.seat.exception.SeatNotFoundException;
import com.rais.bookingapi.seat.models.Seat;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<Seat> getAll() {
        return this.seatRepository.findAll();
    }

    public Seat findOneById(Long id) {
        return this.seatRepository.findById(id).orElseThrow(() -> new SeatNotFoundException());
    }

    public Seat createOne(Seat seat) {
        return this.seatRepository.save(seat);
    }
    
}
