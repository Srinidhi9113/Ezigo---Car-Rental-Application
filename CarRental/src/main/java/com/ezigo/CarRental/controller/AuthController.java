package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.LoginCustomer;
import com.ezigo.CarRental.dto.SignupCustomerDto;
import com.ezigo.CarRental.models.Customer;
import com.ezigo.CarRental.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final List<Customer> customerList;

    private AuthService authService;
    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;

        this.customerList = new ArrayList<>();
        customerList.add(new Customer(1L,"Customer1","Customer1@email","123456789","customer1"));
        customerList.add(new Customer(2L,"Customer2","Customer2@email","364747545","customer2"));
        customerList.add(new Customer(3L,"Customer3","Customer3@email","346346745","customer3"));
        customerList.add(new Customer(4L,"Customer4","Customer4@email","467585858","customer4"));

    }

    @GetMapping("/insert")
    public ResponseEntity<?> addCustomerToDBStatic(){
        for(Customer customer: customerList){
            authService.addCustomerToDBStatic(customer);
        }
        return new ResponseEntity<>("Data inserted to the database successfully !", HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpCustomer(@RequestBody SignupCustomerDto signupCustomerDto){
        if(authService.findCustomerWithEmail(signupCustomerDto.getEmail())){
            return new ResponseEntity<>("Customer with email already exists ",HttpStatus.NOT_ACCEPTABLE);
        }

        SignupCustomerDto newCustomer = authService.createCustomer(signupCustomerDto);
        if(newCustomer == null){
            return new ResponseEntity<>("Invalid Please try again later !!",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginCustomer loginCustomer){
//        if(authService.findCustomerWithEmail(loginCustomer.getEmail()) && authService.findCustomerWithPassword(loginCustomer.getPassword())){
//            return new ResponseEntity<>("Login Successful !!",HttpStatus.ACCEPTED);
//        }
        if(authService.loginCustomer(loginCustomer.getEmail(), loginCustomer.getPassword())){
            return new ResponseEntity<>("Login Successful !!",HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("The username and password do not match !!",HttpStatus.NOT_ACCEPTABLE);
    }



}
