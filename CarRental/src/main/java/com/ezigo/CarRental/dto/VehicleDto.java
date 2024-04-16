package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import com.ezigo.CarRental.models.VehicleReservation;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class VehicleDto {
    private Long id;
    private String licenseNumber;
    private VehicleStatus vehicleStatus;
    private String make;
    private String model;
    private CarType carType;
    private float mileage;
    private int passengerCapacity;
    private float price;
    private byte[] image;

    private VehicleReservation vehicleReservation;
}
