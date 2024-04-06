package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.VehicleReservationStatus;
import com.ezigo.CarRental.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "vehicleReservation")
public class VehicleReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenseNumber;
    private VehicleReservationStatus vehicleReservationStatus;
    private String email;
    private Date creationDate;
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name="vehicle-id")
    private Vehicle vehicle;
}
