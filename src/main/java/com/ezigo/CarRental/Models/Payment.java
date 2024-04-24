package com.ezigo.CarRental.Models;

import com.ezigo.CarRental.Enums.PaymentStatus;
import com.ezigo.CarRental.Enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
