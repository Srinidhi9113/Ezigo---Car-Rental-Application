package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.VehicleLogDto;
import com.ezigo.CarRental.services.VehicleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class VehicleLogController {
    private VehicleLogService vehicleLogService;

    @Autowired
    public VehicleLogController(VehicleLogService vehicleLogService){
        this.vehicleLogService = vehicleLogService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertVehicleLogs(@RequestBody VehicleLogDto vehicleLogDto){
        if(vehicleLogService.insertLogs(vehicleLogDto)){
            return new ResponseEntity<>("Log inserted", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Could not insert Logs",HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("admin/list_all")
    public ResponseEntity<?> listAllLogs(){
        return new ResponseEntity<>(vehicleLogService.listAllLogs(),HttpStatus.FOUND);
    }

    @GetMapping("admin/list")
    public ResponseEntity<?> listLogsForVehicle(@RequestBody VehicleLogDto vehicleLogDto){
        Long id;
        try{
            id = vehicleLogDto.getVehicle().getId();
            return new ResponseEntity<>(vehicleLogService.listLogsForVehicle(id),HttpStatus.FOUND);

        }
        catch(Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("Could not find logs",HttpStatus.NOT_FOUND);

    }

}
