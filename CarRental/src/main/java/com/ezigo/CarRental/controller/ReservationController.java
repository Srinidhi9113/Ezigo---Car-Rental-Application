package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.ReservationDto;
import com.ezigo.CarRental.models.Vehicle;
import com.ezigo.CarRental.models.VehicleReservation;
import com.ezigo.CarRental.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getReservation(){
        Optional<List<VehicleReservation>> myList = Optional.ofNullable(reservationService.getReservation());
        return new ResponseEntity<>(myList,HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReservation(@RequestBody ReservationDto reservationDto){
        ReservationDto dto = reservationService.createReservation(reservationDto);

        if(dto != null){
            return new ResponseEntity<>("Inserted successfully !!",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not insert !!",HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteReservation(@RequestBody ReservationDto reservationDto){
        boolean success = reservationService.deleteReservation(reservationDto);
        if(success){
            return new ResponseEntity<>("Deleted successfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Could not delete",HttpStatus.NOT_ACCEPTABLE);
    }

}
