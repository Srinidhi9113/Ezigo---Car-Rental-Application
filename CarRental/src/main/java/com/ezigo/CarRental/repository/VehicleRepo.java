package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
