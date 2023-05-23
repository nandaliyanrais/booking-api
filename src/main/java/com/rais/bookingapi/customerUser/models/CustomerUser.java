package com.rais.bookingapi.customeruser.models;

import java.sql.Timestamp;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rais.bookingapi.applicationuser.ApplicationUser;
import com.rais.bookingapi.customeruser.models.dto.CustomerUserResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class CustomerUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String email;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private ApplicationUser applicationUser;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public CustomerUserResponse convertToResponse() {
        return CustomerUserResponse.builder()
                .id(this.id)
                .name(this.name)
                .username(this.username)
                .email(this.email)
                .build();
    }

}
