package com.rais.bookingapi.movie.models;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rais.bookingapi.movie.models.dto.response.MovieCreateResponse;
import com.rais.bookingapi.movie.models.dto.response.MovieResponse;
import com.rais.bookingapi.movie.models.dto.response.MovieTitleResponse;
import com.rais.bookingapi.movieSlot.models.MovieSlot;
import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotStudioResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private double duration;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "movie")
    @Cascade(value = CascadeType.PERSIST)
    private List<MovieSlot> movieSlots;

    public MovieResponse convertToResponse() {
        List<MovieSlotStudioResponse> movieSlotResponses = this.movieSlots.stream()
                                                                .sorted(Comparator.comparing(MovieSlot::getJamTayang))
                                                                .map(MovieSlot::convertToResponseStudio)
                                                                .toList();
        return MovieResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .duration(this.duration)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .movieSlotResponses(movieSlotResponses)
                .build();
    }

    public MovieCreateResponse convertToMovieCreateResponse() {
        return MovieCreateResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .duration(this.duration)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    public MovieTitleResponse convertToMovieTitleResponse(){
        return MovieTitleResponse.builder()
                .id(this.id)
                .title(this.title)
                .duration(this.duration)
                .build();
    }

}
