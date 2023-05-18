package com.rais.bookingapi.customerUser;

import org.springframework.stereotype.Service;

import com.rais.bookingapi.customerUser.models.CustomerUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUserService {

    private final CustomerUserRepository customerRepository;

    // public List<CustomerUser> getAll() {
    //     return this.customerRepository.findAll();
    // }

    // public CustomerUser findOneById(Long id) {
    //     return this.customerRepository.findById(id).orElseThrow(() -> new CustomerUserNotFoundException());
    // }
    
    public CustomerUser createOne(CustomerUser customer) {
        return this.customerRepository.save(customer);
    }

}
