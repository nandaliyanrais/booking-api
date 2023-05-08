package com.rais.bookingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}

}

// getAllMovies
// getOneMovie

// Movies
// Long id
// String title
// ENUM status -> available, not available
// createdAt
// updatedAt

// Studio
// Long id
// String name
// int capacity

// MovieStudio
// Long id
// Movie movie -> ManyToOne 
// Studio studio -> ManyToOne