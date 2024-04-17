package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.VehicleStatus;
import lombok.Data;

import java.util.Date;

@Data
public class LogsGetDto {
    private Long id;
    private VehicleStatus vehicleStatus;
    private String description;
    private Date creationDate;
}
