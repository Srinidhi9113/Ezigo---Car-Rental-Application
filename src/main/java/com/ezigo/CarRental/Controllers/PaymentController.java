package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.PaymentDto;
import com.ezigo.CarRental.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertPayment(@RequestBody PaymentDto paymentDto){
        if(paymentService.insertPayment(paymentDto)){
            return new ResponseEntity<>("Payment inserted", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not insert payment",HttpStatus.NOT_ACCEPTABLE);
    }

//    @GetMapping("/get")
//    public ResponseEntity<?> getPayment(@RequestBody Long userId){
//
//    }
}
