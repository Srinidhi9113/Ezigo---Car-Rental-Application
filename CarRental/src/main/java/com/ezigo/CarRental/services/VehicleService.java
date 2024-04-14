package com.ezigo.CarRental.services;

import com.ezigo.CarRental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo){
        this.vehicleRepo = vehicleRepo;
    }

    
}
