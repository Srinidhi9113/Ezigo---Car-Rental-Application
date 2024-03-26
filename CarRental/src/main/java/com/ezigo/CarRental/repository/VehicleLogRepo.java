package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleLogRepo extends JpaRepository<VehicleLog,Long> {
}
