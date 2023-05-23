package com.rais.bookingapi.customeruser;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rais.bookingapi.customeruser.models.CustomerUser;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, Long> {


    
}
