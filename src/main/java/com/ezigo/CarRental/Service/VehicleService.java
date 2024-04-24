package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.VehicleDto;
import com.ezigo.CarRental.Enums.CarType;
import com.ezigo.CarRental.Enums.VehicleStatus;
import com.ezigo.CarRental.Models.Vehicle;
import com.ezigo.CarRental.Models.VehicleFactory;
import com.ezigo.CarRental.Repository.VehicleRepo;
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

    public Optional<List<Vehicle>> getAvailableVehicle(){
        VehicleStatus availableStatus = VehicleStatus.AVAILABLE;
        return Optional.ofNullable(vehicleRepo.findByVehicleStatus(availableStatus));
    }

    public Optional<List<Vehicle>> getAvailableVehiclebyType(CarType carType) {
        VehicleStatus availableStatus = VehicleStatus.AVAILABLE;
        return Optional.ofNullable(vehicleRepo.findByVehicleStatusAndCarType(availableStatus, carType));
    }


    public Optional<Vehicle> getVehicleById(long carid) {
        return vehicleRepo.findById(carid);
    }
}
