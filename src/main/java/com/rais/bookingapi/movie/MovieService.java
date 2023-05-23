package com.rais.bookingapi.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rais.bookingapi.movie.exception.MovieNotFoundException;
import com.rais.bookingapi.movie.models.Movie;
import com.rais.bookingapi.movieslot.models.MovieSlot;
import com.rais.bookingapi.studio.StudioService;
import com.rais.bookingapi.studio.models.Studio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final StudioService studioService;

    public List<Movie> getAll(Optional<String> optionalTitle) {
        if (optionalTitle.isPresent()) {
            return this.movieRepository.findByTitleIgnoreCase(optionalTitle.get());
        }

        return this.movieRepository.findAll();
    }

    public Movie findOneById(Long id) {
        return this.movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException());
    }

    public Movie createOne(Movie movie) {

        // Movie savedMovie = movieRepository.save(movie);
    
        Studio existingStudio = studioService.getAll().get(0);
        List<MovieSlot> movieSlots = new ArrayList<>();
        
        LocalDateTime startTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.NOON); 

        MovieSlot firstMovieSlot = MovieSlot.builder().jamTayang(startTime).movie(movie).studio(existingStudio).build();
        movieSlots.add(firstMovieSlot);
        
        for (int i = 0; i < 4; i++) {
            LocalDateTime jamTayang = movieSlots.get(i).getJamTayang();
            LocalDateTime newJamTayang = jamTayang.plusMinutes((long) (movie.getDuration() + 15));
            MovieSlot newMovieSlot = MovieSlot.builder().jamTayang(newJamTayang).movie(movie).studio(existingStudio).build();
            movieSlots.add(newMovieSlot);
        }
        movie.setMovieSlots(movieSlots);
        
        return movieRepository.save(movie);
    }
    
}
