package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.PaymentDto;
import com.ezigo.CarRental.Models.Payment;
import com.ezigo.CarRental.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
