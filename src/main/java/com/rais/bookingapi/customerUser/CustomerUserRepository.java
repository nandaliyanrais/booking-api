package com.rais.bookingapi.customerUser;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.customerUser.models.CustomerUser;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, Long> {


    
}
