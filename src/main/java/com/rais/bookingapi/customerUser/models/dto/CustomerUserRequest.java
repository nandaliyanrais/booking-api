package com.rais.bookingapi.customeruser.models.dto;

import com.rais.bookingapi.applicationuser.ApplicationUser;
import com.rais.bookingapi.customeruser.models.CustomerUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerUserRequest {
    
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    private String password;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    public CustomerUser convertToEntity() {
        CustomerUser customerUser = CustomerUser.builder()
                .id(this.id)
                .name(this.name)
                .username(this.username)
                .email(this.email)
                .build();
        ApplicationUser applicationUser = ApplicationUser.builder()
                .name(name)
                .username(username)
                .email(email)
                .password(password)
                .build();
        
        customerUser.setApplicationUser(applicationUser);
        applicationUser.setCustomerUser(customerUser);
        
        return customerUser;
    }

}
