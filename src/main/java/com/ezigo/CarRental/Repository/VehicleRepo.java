package com.ezigo.CarRental.Repository;

import com.ezigo.CarRental.Enums.CarType;
import com.ezigo.CarRental.Enums.VehicleStatus;
import com.ezigo.CarRental.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findByVehicleStatusAndCarType(VehicleStatus vehicleStatus, CarType carType);
    List<Vehicle> findByVehicleStatus(VehicleStatus vehicleStatus);

    Optional<Vehicle> findByLicenseNumber(String licenseNumber);
}
