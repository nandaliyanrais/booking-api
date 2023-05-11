package com.rais.bookingapi.studio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rais.bookingapi.studio.exception.StudioNotFoundException;
import com.rais.bookingapi.studio.models.Studio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudioService {
    
    private final StudioRepository studioRepository;

    // public List<Studio> getAll(Optional<String> optionalName) {
    //     if (optionalName.isPresent()) {
    //         return this.studioRepository.findByNameIgnoreCase(optionalName.get());
    //     }

    //     return this.studioRepository.findAll();
    // }

    public List<Studio> getAll() {
        return this.studioRepository.findAll();
    }

    public Studio findOneById(Long id) {
        return this.studioRepository.findById(id).orElseThrow(() -> new StudioNotFoundException());
    }

    public Studio createOne(Studio studio) {
        return this.studioRepository.save(studio);
    }
    
}
