package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleStatus;
import com.ezigo.CarRental.Models.Vehicle;
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
