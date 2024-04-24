package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleStatus;
import lombok.Data;

import java.util.Date;

@Data
public class LogsGetDto {
    private Long id;
    private VehicleStatus vehicleStatus;
    private String description;
    private Date creationDate;
}
