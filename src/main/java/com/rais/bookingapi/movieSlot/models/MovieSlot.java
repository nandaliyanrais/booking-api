package com.rais.bookingapi.movieSlot.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rais.bookingapi.movie.models.Movie;
import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotMovieTitleResponse;
import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotResponse;
import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotStudioResponse;
import com.rais.bookingapi.studio.models.Studio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieSlot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime jamTayang;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @JsonIgnore
    private Studio studio;

    public MovieSlotResponse convertToResponse() {
        return MovieSlotResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movie(this.movie.convertToMovieTitleResponse())
                .studio(this.studio.convertToStudioNameResponse())
                .build();
    }

    public MovieSlotStudioResponse convertToResponseStudio() {
        return MovieSlotStudioResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .studio(this.studio.convertToStudioNameResponse())
                .build();
    }

    public MovieSlotMovieTitleResponse convertToResponseMovie() {
        return MovieSlotMovieTitleResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movie(this.movie.convertToMovieTitleResponse())
                .build();
    }

}
