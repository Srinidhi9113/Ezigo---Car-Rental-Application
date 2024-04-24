package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.PaymentDto;
import com.ezigo.CarRental.Enums.PaymentStatus;
import com.ezigo.CarRental.Models.Bill;
import com.ezigo.CarRental.Models.Payment;
import com.ezigo.CarRental.Repository.BillRepo;
import com.ezigo.CarRental.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepo paymentRepo;

    @Autowired
    BillRepo billRepo;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    public boolean insertPayment(PaymentDto paymentDto){
        Payment newPayment = new Payment();
        newPayment.setPaymentType(paymentDto.getPaymentType());
        newPayment.setPaymentStatus(PaymentStatus.COMPLETED);
        Optional<Bill> bill = billRepo.findById(paymentDto.getBillId());
        if(bill.isPresent()){
            newPayment.setBill(bill.get());
        }
        else{
            return false;
        }
        try{
            Payment payment = paymentRepo.save(newPayment);
            return true;
        }catch(Exception e){
            System.out.println(e);
        }

        return false;
    }



}
