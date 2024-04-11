package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenseNumber;
    private VehicleStatus vehicleStatus;
    private String make;
    private String model;
    private CarType carType;
    private float mileage;
    private int passengerCapacity;
    private float price;
    @Column(columnDefinition = "longblob")
    private byte[] image;

    @OneToOne(mappedBy = "vehicle")
    private VehicleReservation vehicleReservation;

}
