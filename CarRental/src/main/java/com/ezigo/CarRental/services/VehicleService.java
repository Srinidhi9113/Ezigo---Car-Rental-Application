package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.VehicleDto;
import com.ezigo.CarRental.enums.VehicleStatus;
import com.ezigo.CarRental.models.Vehicle;
import com.ezigo.CarRental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.List;

@Service
public class VehicleService {
    private VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo){
        this.vehicleRepo = vehicleRepo;

    }
    public void addVehicleToDBStatic(Vehicle vehicle){
        vehicleRepo.save(vehicle);
    }

    public boolean postCar(VehicleDto vehicleDto) throws IOException {
        try{
            Vehicle vehicle = new Vehicle();
            vehicle.setLicenseNumber(vehicleDto.getLicenseNumber());
            vehicle.setVehicleStatus(vehicleDto.getVehicleStatus());
            vehicle.setMake(vehicleDto.getMake());
            vehicle.setModel(vehicleDto.getModel());
            vehicle.setCarType(vehicleDto.getCarType());
            vehicle.setMileage(vehicleDto.getMileage());
            vehicle.setPassengerCapacity(vehicleDto.getPassengerCapacity());
            vehicle.setPrice(vehicleDto.getPrice());
            vehicle.setImage(vehicleDto.getImage());
            vehicleRepo.save(vehicle);

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean updateCar(VehicleDto vehicleDto) throws IOException{
        try{
            Vehicle vehicle = new Vehicle();

            vehicle.setLicenseNumber(vehicleDto.getLicenseNumber());
            vehicle.setVehicleStatus(vehicleDto.getVehicleStatus());
            vehicle.setMake(vehicleDto.getMake());
            vehicle.setModel(vehicleDto.getModel());
            vehicle.setCarType(vehicleDto.getCarType());
            vehicle.setMileage(vehicleDto.getMileage());
            vehicle.setPassengerCapacity(vehicleDto.getPassengerCapacity());
            vehicle.setPrice(vehicleDto.getPrice());
            vehicle.setImage(vehicleDto.getImage());

            vehicleRepo.save(vehicle);

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean deleteCar(VehicleDto vehicleDto){
        try{
            vehicleRepo.deleteById(vehicleDto.getLicenseNumber());
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public List<Vehicle> listCars(){
        return vehicleRepo.findAll();
    }
}
