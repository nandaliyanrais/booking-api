package com.rais.bookingapi.movieSlot.models.dto.response;

import java.time.LocalDateTime;

import com.rais.bookingapi.movie.models.dto.response.MovieTitleResponse;

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
public class MovieSlotMovieTitleResponse {

    private Long id;
    private LocalDateTime jamTayang;
    private MovieTitleResponse movie;
    
}
