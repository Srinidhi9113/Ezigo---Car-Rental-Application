package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.LogsDto;
import com.ezigo.CarRental.models.VehicleLog;
import com.ezigo.CarRental.services.VehicleLogService;
import com.ezigo.CarRental.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class VehicleLogController {
    private VehicleLogService vehicleLogService;
    @Autowired
    public VehicleLogController(VehicleLogService vehicleLogService){
        this.vehicleLogService = vehicleLogService;
    }
    @GetMapping("/list")
    public ResponseEntity<?> listLogs(){
        Optional<List<VehicleLog>> mylist = Optional.ofNullable(vehicleLogService.listLogs());

        return new ResponseEntity<>(mylist, HttpStatus.FOUND);

    }
    @PostMapping("/insert")
    public ResponseEntity<?> addLogs(@RequestBody  LogsDto logsDto){
        LogsDto log = vehicleLogService.addLogs(logsDto);
        if(log != null){
            return new ResponseEntity<>(log,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Couldn't insert logs",HttpStatus.NOT_ACCEPTABLE);

    }
}
