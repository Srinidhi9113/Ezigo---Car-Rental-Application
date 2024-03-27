package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLogRepo extends JpaRepository<VehicleLog,Long> {
}
