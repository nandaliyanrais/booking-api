package com.rais.bookingapi.movie.models.dto.response;

import java.sql.Timestamp;

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
public class MovieCreateResponse {

    private Long id;
    private String title;
    private String description;
    private double duration;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
}
