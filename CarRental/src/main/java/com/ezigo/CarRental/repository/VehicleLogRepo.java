package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface VehicleLogRepo extends JpaRepository<VehicleLog,Long> {
    Optional<List<VehicleLog>> findAllByVehicleId(Long Id);
}
