package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Models.Vehicle;
import lombok.Data;

import java.util.Date;

@Data
public class VehicleReservationDto {
    private Long id;
    private VehicleReservationStatus vehicleReservationStatus;
    private Date creationDate;
    private Date returnDate;
    private MyUser users;
    private Vehicle vehicle;
}
