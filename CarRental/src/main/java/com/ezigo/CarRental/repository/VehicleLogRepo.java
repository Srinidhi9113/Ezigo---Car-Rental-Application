package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.Optional;

public interface VehicleLogRepo extends JpaRepository<VehicleLog,Long> {
    Optional<List<VehicleLog>> findAllByVehicleId(Long Id);
}
