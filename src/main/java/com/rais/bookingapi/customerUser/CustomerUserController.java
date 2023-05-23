package com.rais.bookingapi.customeruser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rais.bookingapi.customeruser.models.CustomerUser;
import com.rais.bookingapi.customeruser.models.dto.CustomerUserRequest;
import com.rais.bookingapi.customeruser.models.dto.CustomerUserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerUserController {
    
    private final CustomerUserService customerUserService;

    @PostMapping("/register")
    public ResponseEntity<CustomerUserResponse> createOne(@Valid @RequestBody CustomerUserRequest customerRequest) {
        CustomerUser newCustomerUser = customerRequest.convertToEntity();
        CustomerUser saveCustomerUser = this.customerUserService.createOne(newCustomerUser);
        CustomerUserResponse customerUserResponse = saveCustomerUser.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(customerUserResponse);
    }

}
