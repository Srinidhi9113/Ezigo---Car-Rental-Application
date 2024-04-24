package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.LogsGetDto;
import com.ezigo.CarRental.Dto.VehicleLogDto;
import com.ezigo.CarRental.Models.VehicleLog;
import com.ezigo.CarRental.Repository.VehicleLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public List<LogsGetDto> listLogsForVehicle(Long vehicleId){
        Optional<List<VehicleLog>> logs = vehicleLogRepo.findAllByVehicleId(vehicleId);
        return logs.map(this::mapLogsToDto).orElse(Collections.emptyList());
    }

    public List<LogsGetDto> listAllLogs(){
        List<VehicleLog> logs = vehicleLogRepo.findAll();
        return mapLogsToDto(logs);
    }

    private List<LogsGetDto> mapLogsToDto(List<VehicleLog> logs) {
        return logs.stream()
                .map(this::mapLogToDto)
                .collect(Collectors.toList());
    }

    private LogsGetDto mapLogToDto(VehicleLog log) {
        LogsGetDto dto = new LogsGetDto();
        dto.setId(log.getId());
        dto.setVehicleStatus(log.getVehicleStatus());
        dto.setDescription(log.getDescription());
        dto.setCreationDate(log.getCreationDate());
        return dto;
    }


}
