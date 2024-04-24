package com.ezigo.CarRental.Repository;

import com.ezigo.CarRental.Models.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleReservationRepo extends JpaRepository<VehicleReservation, Long> {
    // Query to find reservations by user ID
    @Query("SELECT vr FROM VehicleReservation vr WHERE vr.users.id = :userId")
    List<VehicleReservation> findReservationsByUserId(@Param("userId") Long userId);
}
