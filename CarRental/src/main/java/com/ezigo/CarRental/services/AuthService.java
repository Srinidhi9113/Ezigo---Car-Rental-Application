package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.SignupCustomerDto;
import com.ezigo.CarRental.models.Person;
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

    public void addCustomerToDBStatic(Person customer){
        Person newCustomer = customerRepo.save(customer);
    }

    public boolean findCustomerWithEmail(String email){
        return customerRepo.findFirstByEmail(email).isPresent();
    }
    public boolean findCustomerWithPassword(String password){ return customerRepo.findFirstByPassword(password).isPresent();}
    public boolean createCustomer(SignupCustomerDto signupCustomerDto){
        Person customer = new Person();

        customer.setName(signupCustomerDto.getName());
        customer.setEmail(signupCustomerDto.getEmail());
        customer.setPhoneNo(signupCustomerDto.getPhoneNo());
        customer.setPassword(signupCustomerDto.getPassword());
        Person createdCustomer = customerRepo.save(customer);
        if(createdCustomer == null) return false;
        return true;
    }

    public boolean loginCustomer(String email,String password){
        return customerRepo.findByEmailAndPassword(email, password).isPresent();
    }



}
