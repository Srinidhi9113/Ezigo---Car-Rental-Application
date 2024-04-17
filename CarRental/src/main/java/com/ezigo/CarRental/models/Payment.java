package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.PaymentStatus;
import com.ezigo.CarRental.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

}
