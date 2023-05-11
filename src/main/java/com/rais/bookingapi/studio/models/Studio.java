package com.rais.bookingapi.studio.models;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rais.bookingapi.movieSlot.models.MovieSlot;
import com.rais.bookingapi.movieSlot.models.dto.response.MovieSlotMovieTitleResponse;
import com.rais.bookingapi.studio.models.dto.response.StudioCreateResponse;
import com.rais.bookingapi.studio.models.dto.response.StudioNameResponse;
import com.rais.bookingapi.studio.models.dto.response.StudioResponse;

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

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private int capacity;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "studio")
    @Cascade(value = CascadeType.ALL)
    private List<MovieSlot> movieSlots;

    public StudioResponse convertToResponse() {
        
        List<MovieSlotMovieTitleResponse> movieSlotResponses = this.movieSlots.stream()
                                                                    .sorted(Comparator.comparing(MovieSlot::getJamTayang))
                                                                    .map(MovieSlot::convertToResponseMovie)
                                                                    .toList();
        return StudioResponse.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .movieSlotResponses(movieSlotResponses)
                .build();
    }

    public StudioCreateResponse convertToResponseCreate() {
        return StudioCreateResponse.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    public StudioNameResponse convertToResponseStudio() {
        return StudioNameResponse.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .build();
    }

}
