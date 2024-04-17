package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.VehicleReservationStatus;
import com.ezigo.CarRental.models.Vehicle;
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
