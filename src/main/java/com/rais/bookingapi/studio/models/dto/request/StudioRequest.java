package com.rais.bookingapi.studio.models.dto.request;

import com.rais.bookingapi.studio.models.Studio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudioRequest {
    
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Positive(message = "Capacity must be greater than 0")
    private int capacity;

    public Studio convertToEntity() {
        return Studio.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .build();
    }

    public Studio convertToEntityName() {
        return Studio.builder()
                .name(this.name)
                .build();
    }

}
