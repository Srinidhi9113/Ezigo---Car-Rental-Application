package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.LoginCustomerDto;
import com.ezigo.CarRental.dto.PaymentDto;
import com.ezigo.CarRental.models.Payment;
import com.ezigo.CarRental.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/admin/list")
    public ResponseEntity<?> listPaymentsAdmin(){
        return new ResponseEntity<>(paymentService.listPaymentsAdmin(), HttpStatus.FOUND);
    }

    @PostMapping("insert")
    public ResponseEntity<?> insertPayment(@RequestBody PaymentDto paymentDto){
        boolean success = paymentService.insertPayment(paymentDto);

        if(success){
            return new ResponseEntity<>("Payment inserted !!", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Could not insert payment",HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPayment(@RequestBody LoginCustomerDto loginCustomerDto){

        return new ResponseEntity<>(paymentService.listPayment(loginCustomerDto),HttpStatus.FOUND);
    }
}
