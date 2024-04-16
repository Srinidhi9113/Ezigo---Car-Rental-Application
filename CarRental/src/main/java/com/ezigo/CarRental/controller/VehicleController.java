package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.VehicleDto;
import com.ezigo.CarRental.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }


    @PostMapping("/insert")
    public ResponseEntity<?> insertVehicle(@RequestBody VehicleDto vehicleDto){
        if(vehicleService.insertVehicle(vehicleDto)) return new ResponseEntity<>("Vehicle inserted", HttpStatus.CREATED);
        return new ResponseEntity<>("Vehicle not inserted",HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getVehicle(){
        return new ResponseEntity<>(vehicleService.getVehicle(),HttpStatus.FOUND);
    }
}
