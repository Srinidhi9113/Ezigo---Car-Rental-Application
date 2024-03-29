package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.LogsDto;
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
    public List<VehicleLog> listLogs(){
        return vehicleLogRepo.findAll();
    }
    public LogsDto addLogs(LogsDto logsDto){
        VehicleLog vehicleLog = new VehicleLog();
        vehicleLog.setLicenseNumber(logsDto.getLicenseNumber());
        vehicleLog.setVehicleStatus(logsDto.getVehicleStatus());
        vehicleLog.setDescription(logsDto.getDescription());
        vehicleLog.setCreationDate(logsDto.getCreationDate());

        VehicleLog newLog = vehicleLogRepo.save(vehicleLog);

        LogsDto log = new LogsDto();
        log.setId(newLog.getId());

        return log;

    }
}
