package com.rais.bookingapi.movieSlot.models.dto.request;

import java.time.LocalDateTime;

import com.rais.bookingapi.movie.models.dto.request.MovieRequest;
import com.rais.bookingapi.movieSlot.models.MovieSlot;
import com.rais.bookingapi.studio.models.dto.request.StudioRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSlotRequest {
    
    private Long id;

    private LocalDateTime jamTayang;

    private MovieRequest movie;

    private StudioRequest studio;

    public MovieSlot convertToEntity() {
        return MovieSlot.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movie(this.movie.convertToEntityTitle())
                .studio(this.studio.convertToEntityName())
                .build();
    }

}
