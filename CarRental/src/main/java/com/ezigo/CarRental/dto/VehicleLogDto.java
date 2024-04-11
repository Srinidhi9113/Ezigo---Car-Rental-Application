package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.VehicleStatus;
import com.ezigo.CarRental.models.Vehicle;
import lombok.Data;

import java.util.Date;

@Data
public class VehicleLogDto {
    private Long id;
    private Vehicle vehicle;
    private VehicleStatus vehicleStatus;
    private String description;
    private Date creationDate;
}
