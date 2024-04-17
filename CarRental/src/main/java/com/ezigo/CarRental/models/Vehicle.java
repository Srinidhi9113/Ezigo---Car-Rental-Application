package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private VehicleReservation vehicleReservation;

    @OneToOne(mappedBy = "vehicle")
    private VehicleLog vehicleLog;


    public Vehicle(String licenseNumber, VehicleStatus vehicleStatus, String make, String model,
                   CarType carType, float mileage, int passengerCapacity, float price, byte[] image) {

        this.licenseNumber = licenseNumber;
        this.vehicleStatus = vehicleStatus;
        this.make = make;
        this.model = model;
        this.carType = carType;
        this.mileage = mileage;
        this.passengerCapacity = passengerCapacity;
        this.price = price;
        this.image = image;
    }

}
