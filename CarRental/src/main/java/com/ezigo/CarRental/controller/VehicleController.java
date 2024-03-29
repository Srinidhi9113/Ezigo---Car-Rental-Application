package com.ezigo.CarRental.controller;


import com.ezigo.CarRental.dto.VehicleDto;
import com.ezigo.CarRental.models.Vehicle;
import com.ezigo.CarRental.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private List<Vehicle> myVehicleList;
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> postCar(@RequestBody VehicleDto vehicleDto) throws IOException{
       boolean success =  vehicleService.postCar(vehicleDto);

       if(success){
           return new ResponseEntity<>("Vehicle Added Successfully !!", HttpStatus.ACCEPTED);
       }

       return new ResponseEntity<>("Could not add vehicle !!",HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCar(@RequestBody VehicleDto vehicleDto) throws IOException {
        boolean success = vehicleService.updateCar(vehicleDto);
        if(success){
            return new ResponseEntity<>("Updated successfully !!",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Could not update",HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCar(@RequestBody VehicleDto vehicleDto){
        boolean success = vehicleService.deleteCar(vehicleDto);
        if(success) {
            return new ResponseEntity<>("Deleted Successfully !!",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Could not delete ",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listCars(){
        Optional<List<Vehicle>> mylist = Optional.ofNullable(vehicleService.listCars());

        return new ResponseEntity<>(mylist,HttpStatus.FOUND);
    }


}
