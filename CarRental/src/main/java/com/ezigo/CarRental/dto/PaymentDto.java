package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.PaymentStatus;
import com.ezigo.CarRental.enums.PaymentType;
import com.ezigo.CarRental.models.Bill;
import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Bill bill;
}
