package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,String> {

    Optional<Vehicle> findFirstByLicenseNumber(String licenseNumber);
}
