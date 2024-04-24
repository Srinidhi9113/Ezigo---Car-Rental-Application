package com.ezigo.CarRental.Models;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VehicleReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private VehicleReservationStatus vehicleReservationStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private MyUser users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "vehicleReservation",orphanRemoval = true)
    private Bill bill;
}
