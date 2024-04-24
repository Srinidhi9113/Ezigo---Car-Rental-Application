package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Models.Vehicle;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class VehicleReservationDto {
    private String name;
    private String email;
    private String phone;
    private String carDetails;
    private String carRegNum;
    private Date fromDate;
    private Date toDate;

    // Constructors, getters, and setters
}
