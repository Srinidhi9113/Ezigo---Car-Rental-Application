package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.CarType;
import com.ezigo.CarRental.Enums.VehicleStatus;
import com.ezigo.CarRental.Models.VehicleReservation;
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
