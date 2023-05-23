package com.rais.bookingapi.customeruser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rais.bookingapi.applicationuser.ApplicationUser;
import com.rais.bookingapi.customeruser.models.CustomerUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUserService {

    private final CustomerUserRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // public List<CustomerUser> getAll() {
    //     return this.customerRepository.findAll();
    // }

    // public CustomerUser findOneById(Long id) {
    //     return this.customerRepository.findById(id).orElseThrow(() -> new CustomerUserNotFoundException());
    // }
    
    public CustomerUser createOne(CustomerUser customer) {
        ApplicationUser applicationUser = customer.getApplicationUser();
        String hashPassword = bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(hashPassword);

        return this.customerRepository.save(customer);
    }

}
