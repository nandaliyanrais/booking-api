package com.rais.bookingapi.authentication.models.dto;

import lombok.Data;

@Data
public class JwtResponseDto {
    
    private String token;
    private String type = "Bearer";

    public JwtResponseDto(String token) {
        this.token = token;
    }
    
}
