package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    // Private constructor to prevent instantiation of the factory class
    private VehicleFactory() {}

    // Map to hold the constructors for each car type
    private static final Map<CarType, VehicleConstructor> constructors = new HashMap<>();

    // Functional interface for vehicle constructors
    @FunctionalInterface
    private interface VehicleConstructor {
        Vehicle create(String licenseNumber, VehicleStatus vehicleStatus, String make, String model,
                       CarType carType, float mileage, int passengerCapacity, float price, byte[] image);
    }

    // Register constructors for each car type
    static {
        constructors.put(CarType.ECONOMY, EconomyCar::new);
        constructors.put(CarType.COMPACT, CompactCar::new);
//        constructors.put(CarType.STANDARD, StandardCar::new);
//        constructors.put(CarType.PREMIUM, PremiumCar::new);
//        constructors.put(CarType.LUXURY, LuxuryCar::new);
    }

    // Static factory method to create instances of Vehicle based on CarType
    public static Vehicle createVehicle(String licenseNumber, VehicleStatus vehicleStatus,
                                        String make, String model, CarType carType,
                                        float mileage, int passengerCapacity, float price,
                                        byte[] image) {
        VehicleConstructor constructor = constructors.get(carType);
        if (constructor == null) {
            throw new IllegalArgumentException("Unsupported car type: " + carType);
        }
        return constructor.create(licenseNumber, vehicleStatus, make, model, carType,
                mileage, passengerCapacity, price, image);
    }
}
