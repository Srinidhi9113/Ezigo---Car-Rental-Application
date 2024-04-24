package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.PaymentDto;
import com.ezigo.CarRental.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/insert")
    public String insertPayment(@ModelAttribute PaymentDto paymentDto){
        if(paymentService.insertPayment(paymentDto)){
            return "redirect:/user/all";
        }
        return "redirect:/error";
    }

//    @GetMapping("/get")
//    public ResponseEntity<?> getPayment(@RequestBody Long userId){
//
//    }
}
