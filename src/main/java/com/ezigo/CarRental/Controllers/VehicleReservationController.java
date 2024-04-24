package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.VehicleReservationDto;
import com.ezigo.CarRental.Service.VehicleReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class VehicleReservationController {
    private final VehicleReservationService vehicleReservationService;

    @Autowired
    public VehicleReservationController(VehicleReservationService vehicleReservationService){
        this.vehicleReservationService = vehicleReservationService;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getReservation(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(vehicleReservationService.getReservation(userId), HttpStatus.FOUND);
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insertReservation(@ModelAttribute VehicleReservationDto vehicleReservationDto){
        if(vehicleReservationService.insertReservation(vehicleReservationDto)){
            return new ResponseEntity<>("Reservaton created ",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not create reservation",HttpStatus.NOT_ACCEPTABLE);
    }
}
