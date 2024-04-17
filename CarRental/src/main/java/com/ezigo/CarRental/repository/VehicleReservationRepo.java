package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleReservationRepo extends JpaRepository<VehicleReservation, Long> {
    // Query to find reservations by user ID
    @Query("SELECT vr FROM VehicleReservation vr WHERE vr.users.id = :userId")
    List<VehicleReservation> findReservationsByUserId(@Param("userId") Long userId);
}
