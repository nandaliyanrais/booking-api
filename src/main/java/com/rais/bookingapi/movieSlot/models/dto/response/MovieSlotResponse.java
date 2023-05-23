package com.rais.bookingapi.movieslot.models.dto.response;

import java.time.LocalDateTime;

import com.rais.bookingapi.movie.models.dto.response.MovieTitleResponse;
import com.rais.bookingapi.studio.models.dto.response.StudioNameResponse;

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
public class MovieSlotResponse {
    
    private Long id;
    private LocalDateTime jamTayang;
    private MovieTitleResponse movie;
    private StudioNameResponse studio;

}
