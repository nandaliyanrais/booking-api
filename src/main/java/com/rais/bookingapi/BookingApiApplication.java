package com.rais.bookingapi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
public class BookingApiApplication {

	// @Bean(name="filterMultipartResolver")    
	// public MultipartFilter getMultipartResolver() throws IOException{        
	// 	MultipartFilter resolver = new MultipartFilter();        
	// 	resolver.setMultipartResolverBeanName(multipartresolver);      
	// 	resolver.(5242880);	//5MB                 
		
	// 	return resolver;    
	// }

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}

}