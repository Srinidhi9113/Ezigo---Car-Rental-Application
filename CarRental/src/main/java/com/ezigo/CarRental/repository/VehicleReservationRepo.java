package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReservationRepo extends JpaRepository<VehicleReservation,Long> {
}
