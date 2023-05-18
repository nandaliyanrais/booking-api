package com.rais.bookingapi.studio;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.common.EnableCallLogging;
import com.rais.bookingapi.studio.models.Studio;
import com.rais.bookingapi.studio.models.dto.request.StudioRequest;
import com.rais.bookingapi.studio.models.dto.response.StudioCreateResponse;
import com.rais.bookingapi.studio.models.dto.response.StudioResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudioController {

    private final StudioService studioService;

    // @GetMapping("/studios")
    // public ResponseEntity<List<StudioResponse>> getAll(@RequestParam(value = "name") Optional<String> optionalName) {
    //     List<Studio> studios = studioService.getAll(optionalName);
    //     List<StudioResponse> studioResponses = studios.stream().map(studio -> studio.convertToResponse()).toList();

    //     return ResponseEntity.status(HttpStatus.OK).body(studioResponses);
    // }

    @GetMapping("/studios")
    public ResponseEntity<List<StudioResponse>> getAll() {
        List<Studio> studios = studioService.getAll();
        List<StudioResponse> studioResponses = studios.stream().map(studio -> studio.convertToResponse()).toList();

        return ResponseEntity.status(HttpStatus.OK).body(studioResponses);
    }

    @GetMapping("/studios/{id}")
    public ResponseEntity<StudioResponse> getOneStudio(@PathVariable("id") Long id) {
        Studio existingStudio = this.studioService.findOneById(id);
        StudioResponse studioResponse = existingStudio.convertToResponse();

        return ResponseEntity.ok(studioResponse);
    }

    @PostMapping("/studios")
    @EnableCallLogging
    public ResponseEntity<StudioCreateResponse> createOne(@Valid @RequestBody StudioRequest studioRequest) {
        if (studioRequest.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Studio newStudio = studioRequest.convertToEntity();
        Studio saveStudio = this.studioService.createOne(newStudio);
        StudioCreateResponse studioResponse = saveStudio.convertToStudioCreateResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(studioResponse);
    }

}
