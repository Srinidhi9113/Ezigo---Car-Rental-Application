package com.ezigo.CarRental.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.PayloadApplicationEvent;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float amount;
    private Date createdDate;

    @OneToOne(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private VehicleReservation vehicleReservation;

}
