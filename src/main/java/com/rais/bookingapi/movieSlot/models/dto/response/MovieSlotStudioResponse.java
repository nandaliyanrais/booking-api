package com.rais.bookingapi.movieSlot.models.dto.response;

import java.time.LocalDateTime;

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
public class MovieSlotStudioResponse {

    private Long id;
    private LocalDateTime jamTayang;
    private StudioNameResponse studio;

}
