package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.VehicleDto;
import com.ezigo.CarRental.models.Vehicle;
import com.ezigo.CarRental.models.VehicleFactory;
import com.ezigo.CarRental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo){
        this.vehicleRepo = vehicleRepo;
    }

    public boolean insertVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = VehicleFactory.createVehicle(
                vehicleDto.getLicenseNumber(),
                vehicleDto.getVehicleStatus(),
                vehicleDto.getMake(),
                vehicleDto.getModel(),
                vehicleDto.getCarType(),
                vehicleDto.getMileage(),
                vehicleDto.getPassengerCapacity(),
                vehicleDto.getPrice(),
                vehicleDto.getImage());
        try{
            Vehicle newVehicle = vehicleRepo.save(vehicle);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public Optional<List<Vehicle>> getVehicle(){
        return Optional.of(vehicleRepo.findAll());
    }

    
}
