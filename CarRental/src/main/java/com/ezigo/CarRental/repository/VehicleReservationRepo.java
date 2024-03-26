package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleReservationRepo extends JpaRepository<VehicleReservation,Long> {
}
