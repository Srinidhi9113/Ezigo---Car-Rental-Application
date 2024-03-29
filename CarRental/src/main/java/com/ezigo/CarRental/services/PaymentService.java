package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.PaymentDto;
import com.ezigo.CarRental.enums.PaymentStatus;
import com.ezigo.CarRental.models.Payment;
import com.ezigo.CarRental.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepo paymentRepo;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    public List<Payment> listPaymentsAdmin(){
        return paymentRepo.findAll();
    }

    public boolean insertPayment(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setEmail(paymentDto.getEmail());
        payment.setPaymentStatus(PaymentStatus.valueOf("PENDING"));
        payment.setCreationDate(paymentDto.getCreationDate());
        payment.setPaymentType(paymentDto.getPaymentType());
        payment.setLicenseNumber(paymentDto.getLicenseNumber());

        Payment newPay = paymentRepo.save(payment);

        if(newPay != null){
            payment.setPaymentStatus(PaymentStatus.valueOf("COMPLETED"));
            newPay = paymentRepo.save(payment);
            return true;
        }
        return false;


    }

}
