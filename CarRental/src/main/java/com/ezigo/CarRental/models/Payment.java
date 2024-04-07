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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Bill bill;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
// try to implement factory pattern
    private Date creationDate;
    private Vehicle vehicle;
    private Member member;

}
