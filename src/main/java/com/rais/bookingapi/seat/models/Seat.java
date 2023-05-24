package com.rais.bookingapi.seat.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rais.bookingapi.customeruser.models.CustomerUser;
import com.rais.bookingapi.movieslot.models.MovieSlot;
import com.rais.bookingapi.seat.models.dto.SeatResponse;

import jakarta.persistence.Column;
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
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    // @OneToMany(mappedBy = "seat")
    // @Cascade(value = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private CustomerUser customerUser;

    @ManyToOne
    @JoinColumn(name = "movie_slot_id")
    private MovieSlot movieSlot;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public SeatResponse convertToResponse() {
        return SeatResponse.builder()
                .id(this.id)
                .seatNumber(this.seatNumber)
                .customerUser(this.customerUser)
                .movieSlot(this.movieSlot)
                .build();
    }
}
