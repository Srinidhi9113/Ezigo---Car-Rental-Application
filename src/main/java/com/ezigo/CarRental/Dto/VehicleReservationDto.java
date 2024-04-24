package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Models.Vehicle;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class VehicleReservationDto {
    private String name;
    private String email;
    private String phone;
    private String carDetails;
    private String carRegNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    // Constructors, getters, and setters
}
