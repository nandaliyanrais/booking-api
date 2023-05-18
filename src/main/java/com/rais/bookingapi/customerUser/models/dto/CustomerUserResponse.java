package com.rais.bookingapi.customerUser.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUserResponse {
    
    private Long id;
    private String name;
    private String username;
    private String email;

}
