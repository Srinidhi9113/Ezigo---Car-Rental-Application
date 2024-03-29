package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.ReservationDto;
import com.ezigo.CarRental.enums.VehicleReservationStatus;
import com.ezigo.CarRental.models.VehicleReservation;
import com.ezigo.CarRental.repository.VehicleReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private VehicleReservationRepo vehicleReservationRepo;
    @Autowired
    public ReservationService(VehicleReservationRepo vehicleReservationRepo){
        this.vehicleReservationRepo = vehicleReservationRepo;
    }

    public List<VehicleReservation> getReservation(){
        return vehicleReservationRepo.findAll();
    }

    public ReservationDto createReservation(ReservationDto reservationDto){
        VehicleReservation vehicleReservation = new VehicleReservation();

        vehicleReservation.setEmail(reservationDto.getEmail());
        vehicleReservation.setLicenseNumber(reservationDto.getLicenseNumber());
        vehicleReservation.setVehicleReservationStatus(VehicleReservationStatus.valueOf("PENDING"));
        vehicleReservation.setCreationDate(reservationDto.getCreationDate());
        vehicleReservation.setReturnDate(reservationDto.getReturnDate());

        VehicleReservation newReservation = vehicleReservationRepo.save(vehicleReservation);

        ReservationDto newDto = new ReservationDto();
        newDto.setId(newReservation.getId());

        vehicleReservation.setVehicleReservationStatus(VehicleReservationStatus.valueOf("ACTIVE"));
        newReservation = vehicleReservationRepo.save(vehicleReservation);

        return newDto;

    }

    public boolean deleteReservation(ReservationDto reservationDto){
        try{
            vehicleReservationRepo.deleteById(reservationDto.getId());
            return true;
        }catch(Exception e){
            System.out.println(e);
        }

        return false;
    }


}
