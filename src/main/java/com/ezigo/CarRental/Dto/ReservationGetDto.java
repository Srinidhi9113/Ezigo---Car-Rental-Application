package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import com.ezigo.CarRental.Models.Vehicle;
import lombok.Data;

import java.util.Date;
@Data
public class ReservationGetDto {
    private Long id;
    private Date creationDate;
    private Date returnDate;
    private VehicleReservationStatus vehicleReservationStatus;
    private Vehicle vehicle;
}
