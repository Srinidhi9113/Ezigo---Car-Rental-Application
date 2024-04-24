package com.ezigo.CarRental.Models;

import com.ezigo.CarRental.Enums.CarType;
import com.ezigo.CarRental.Enums.VehicleStatus;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CompactCar extends Vehicle {
    // Constructor
    public CompactCar(String licenseNumber, VehicleStatus vehicleStatus, String make, String model, CarType carType, float mileage,
                      int passengerCapacity, float price, byte[] image) {


        super(licenseNumber, vehicleStatus, make, model, carType, mileage, passengerCapacity, price, image);
    }

}
