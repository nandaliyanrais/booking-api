package com.rais.bookingapi.studio.models.dto.response;

import java.sql.Timestamp;
import java.util.List;

import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotMovieTitleResponse;

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
public class StudioResponse {
    
    private Long id;
    private String name;
    private int capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<MovieSlotMovieTitleResponse> movieSlotResponses;

}
