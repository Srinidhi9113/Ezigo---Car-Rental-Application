package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.PaymentStatus;
import com.ezigo.CarRental.enums.PaymentType;
import com.ezigo.CarRental.models.Payment;
import lombok.Data;

import java.util.Date;
@Data
public class PaymentDto {
    private Long id;
    private float amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Date creationDate;
    private String licenseNumber;
    private String email;
}
