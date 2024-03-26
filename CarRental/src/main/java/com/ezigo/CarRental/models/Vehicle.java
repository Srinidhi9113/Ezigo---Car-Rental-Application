package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;
    private String licenseNumber;
    private VehicleStatus vehicleStatus;
    private String model;
    private CarType carType;
    private float mileage;
    private int passengerCapacity;
    private float price;

}
