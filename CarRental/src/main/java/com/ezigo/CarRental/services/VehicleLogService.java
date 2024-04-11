package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.VehicleLogDto;
import com.ezigo.CarRental.models.VehicleLog;
import com.ezigo.CarRental.repository.VehicleLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleLogService {
    private VehicleLogRepo vehicleLogRepo;

    @Autowired
    public VehicleLogService(VehicleLogRepo vehicleLogRepo){
        this.vehicleLogRepo = vehicleLogRepo;
    }

    public boolean insertLogs(VehicleLogDto vehicleLogDto){
        VehicleLog newLog = new VehicleLog();
        newLog.setVehicle(vehicleLogDto.getVehicle());
        newLog.setDescription(vehicleLogDto.getDescription());
        newLog.setVehicleStatus(vehicleLogDto.getVehicleStatus());
        newLog.setCreationDate(vehicleLogDto.getCreationDate());
        try{
            VehicleLog log = vehicleLogRepo.save(newLog);
            return true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public Optional<List<VehicleLog>> listLogsForVehicle(Long vehicleId){
        return vehicleLogRepo.findAllByVehicleId(vehicleId);
    }

    public Optional<List<VehicleLog>> listAllLogs(){
        return Optional.of(vehicleLogRepo.findAll());
    }


}
