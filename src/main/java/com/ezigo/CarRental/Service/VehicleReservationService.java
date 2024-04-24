package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.ReservationGetDto;
import com.ezigo.CarRental.Dto.VehicleReservationDto;
import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import com.ezigo.CarRental.Enums.VehicleStatus;
import com.ezigo.CarRental.Models.Bill;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Models.Vehicle;
import com.ezigo.CarRental.Models.VehicleReservation;
import com.ezigo.CarRental.Repository.UserRepo;
import com.ezigo.CarRental.Repository.VehicleRepo;
import com.ezigo.CarRental.Repository.VehicleReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class VehicleReservationService {
    private final VehicleReservationRepo vehicleReservationRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    public VehicleReservationService(VehicleReservationRepo vehicleReservationRepo){
        this.vehicleReservationRepo = vehicleReservationRepo;
    }

    public Optional<List<ReservationGetDto>> getReservation(Long id){
        Optional<List<VehicleReservation>> optionalReservations = Optional.ofNullable(vehicleReservationRepo.findReservationsByUserId(id));

        if (optionalReservations.isPresent()) {
            List<VehicleReservation> reservations = optionalReservations.get();
            List<ReservationGetDto> reservationGetDtos = new ArrayList<>();

            for (VehicleReservation reservation : reservations) {
                ReservationGetDto dto = new ReservationGetDto();
                dto.setId(reservation.getId());
                dto.setVehicleReservationStatus(reservation.getVehicleReservationStatus());
                dto.setCreationDate(reservation.getCreationDate());
                dto.setReturnDate(reservation.getReturnDate());
                dto.setVehicle(reservation.getVehicle());
                reservationGetDtos.add(dto);
            }

            return Optional.of(reservationGetDtos);
        } else {
            return Optional.empty();
        }
    }

    public VehicleReservation insertReservation(VehicleReservationDto vehicleReservationDto) {
        try {
            Optional<MyUser> user = userRepo.findByUsername(vehicleReservationDto.getName());
            Optional<Vehicle> car = vehicleRepo.findByLicenseNumber(vehicleReservationDto.getCarRegNum());
            if (user.isPresent() && car.isPresent()) {
                VehicleReservation reservation = new VehicleReservation();
                reservation.setVehicleReservationStatus(VehicleReservationStatus.PENDING);
                reservation.setCreationDate(vehicleReservationDto.getFromDate());
                reservation.setReturnDate(vehicleReservationDto.getToDate());
                MyUser newUser = user.get();
                Vehicle newCar = car.get();
                newCar.setVehicleStatus(VehicleStatus.RESERVED);
                vehicleRepo.save(newCar);
                reservation.setUsers(newUser);
                reservation.setVehicle(newCar);

                return vehicleReservationRepo.save(reservation);
            } else {
                // Handle case where user or car is not found
                return null;
            }
        } catch (Exception e) {
            // Handle specific exceptions or log the error
            System.err.println("Error creating reservation: " + e.getMessage());
            return null;
        }
    }
}
