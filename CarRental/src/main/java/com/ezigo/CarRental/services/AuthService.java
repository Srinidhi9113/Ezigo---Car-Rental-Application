package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.SignupCustomerDto;
import com.ezigo.CarRental.models.Customer;
import com.ezigo.CarRental.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private CustomerRepo customerRepo;
    @Autowired
    public AuthService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public void addCustomerToDBStatic(Customer customer){
        Customer newCustomer = customerRepo.save(customer);
    }

    public boolean findCustomerWithEmail(String email){
        return customerRepo.findFirstByEmail(email).isPresent();
    }
    public boolean findCustomerWithPassword(String password){ return customerRepo.findFirstByPassword(password).isPresent();}
    public SignupCustomerDto createCustomer(SignupCustomerDto signupCustomerDto){
        Customer customer = new Customer();

        customer.setName(signupCustomerDto.getName());
        customer.setEmail(signupCustomerDto.getEmail());
        customer.setPhoneNo(signupCustomerDto.getPhoneNo());
        customer.setPassword(signupCustomerDto.getPassword());

        Customer createdCustomer = customerRepo.save(customer);

        SignupCustomerDto newCustomer = new SignupCustomerDto();
        newCustomer.setId(createdCustomer.getId());

        return newCustomer;

    }

    public boolean loginCustomer(String email,String password){
        return customerRepo.findByEmailAndPassword(email, password).isPresent();
    }



}
