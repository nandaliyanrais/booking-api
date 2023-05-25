package com.rais.bookingapi.image;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.image.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    public Optional<Image> findByName(String name);
    
}
