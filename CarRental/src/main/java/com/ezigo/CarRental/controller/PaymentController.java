package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.PaymentDto;
import com.ezigo.CarRental.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>("Payment inserted !!", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Could not insert payment",HttpStatus.NOT_ACCEPTABLE);
    }
}
