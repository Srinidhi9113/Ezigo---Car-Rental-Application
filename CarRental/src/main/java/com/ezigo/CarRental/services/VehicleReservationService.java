package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.VehicleReservationDto;
import com.ezigo.CarRental.models.VehicleReservation;
import com.ezigo.CarRental.repository.VehicleReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleReservationService {
    private final VehicleReservationRepo vehicleReservationRepo;

    @Autowired
    public VehicleReservationService(VehicleReservationRepo vehicleReservationRepo){
        this.vehicleReservationRepo = vehicleReservationRepo;
    }

    public Optional<List<VehicleReservation>> getReservation(Long id){
        return vehicleReservationRepo.findReservationByUserId(id);
    }
    public boolean insertReservation(VehicleReservationDto vehicleReservationDto){
        VehicleReservation reservation = new VehicleReservation();
        reservation.setVehicleReservationStatus(vehicleReservationDto.getVehicleReservationStatus());
        reservation.setCreationDate(vehicleReservationDto.getCreationDate());
        reservation.setReturnDate(vehicleReservationDto.getReturnDate());
        reservation.setUsers(vehicleReservationDto.getUsers());
        try{
            VehicleReservation newReservation = vehicleReservationRepo.save(reservation);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }

        return false;

    }
}
