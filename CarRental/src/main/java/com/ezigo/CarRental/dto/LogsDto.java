package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import lombok.Data;

import java.util.Date;
@Data
public class LogsDto {
    private Long id;
    private String licenseNumber;
    private VehicleStatus vehicleStatus;
    private String description;
    private Date creationDate;
}
