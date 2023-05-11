package com.rais.bookingapi.studio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.studio.models.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {

    public List<Studio> findByNameIgnoreCase(String name);
    
}
