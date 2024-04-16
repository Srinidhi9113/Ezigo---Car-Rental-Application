package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.PaymentDto;
import com.ezigo.CarRental.models.Bill;
import com.ezigo.CarRental.models.Payment;
import com.ezigo.CarRental.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepo paymentRepo;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    public boolean insertPayment(PaymentDto paymentDto){
        Payment newPayment = new Payment();
        newPayment.setPaymentType(paymentDto.getPaymentType());
        newPayment.setPaymentStatus(paymentDto.getPaymentStatus());
        newPayment.setBill(paymentDto.getBill());
        try{
            Payment payment = paymentRepo.save(newPayment);
            return true;
        }catch(Exception e){
            System.out.println(e);
        }

        return false;
    }



}
