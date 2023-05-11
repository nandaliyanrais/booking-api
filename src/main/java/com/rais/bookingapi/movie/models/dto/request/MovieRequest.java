package com.rais.bookingapi.movie.models.dto.request;

import com.rais.bookingapi.movie.models.Movie;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    private double duration;

    public Movie convertToEntity() {
        return Movie.builder()
                .id(id)
                .title(title)
                .description(description)
                .duration(duration)
                .build();
    }

    public Movie convertToEntityTitle() {
        return Movie.builder()
                .title(title)
                .build();
    }

}
