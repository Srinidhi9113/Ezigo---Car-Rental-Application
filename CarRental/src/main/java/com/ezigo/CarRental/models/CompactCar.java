package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;

public class CompactCar extends Vehicle {
    // Constructor
    public CompactCar(String licenseNumber, VehicleStatus vehicleStatus, String make, String model, CarType carType, float mileage,
                      int passengerCapacity, float price, byte[] image) {


        super(licenseNumber, vehicleStatus, make, model, carType, mileage, passengerCapacity, price, image);
    }

}