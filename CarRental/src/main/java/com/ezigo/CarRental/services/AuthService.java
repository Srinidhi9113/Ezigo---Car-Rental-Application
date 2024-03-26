package com.ezigo.CarRental.services;

import com.ezigo.CarRental.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private CustomerRepo customerRepo;
    @Autowired
    public AuthService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }



}
