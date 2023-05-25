package com.rais.bookingapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rais.bookingapi.image.ImageService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class BookingApiApplication implements CommandLineRunner  {

	@Resource
	ImageService imageService;

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// imageService.deleteAll(); // untuk delete images
		imageService.init();
	}

}