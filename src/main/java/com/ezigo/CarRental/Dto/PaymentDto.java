package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.PaymentStatus;
import com.ezigo.CarRental.Enums.PaymentType;
import com.ezigo.CarRental.Models.Bill;
import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private PaymentType paymentType;
    private Long billId;
}
