package com.rais.bookingapi.movie.models.dto.response;

import java.sql.Timestamp;
import java.util.List;

import com.rais.bookingapi.movieslot.models.dto.response.MovieSlotStudioResponse;

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
public class MovieResponse {
    
    private Long id;
    private String title;
    private String description;
    private double duration;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<MovieSlotStudioResponse> movieSlotResponses;

}
