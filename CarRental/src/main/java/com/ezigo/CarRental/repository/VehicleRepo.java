package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
