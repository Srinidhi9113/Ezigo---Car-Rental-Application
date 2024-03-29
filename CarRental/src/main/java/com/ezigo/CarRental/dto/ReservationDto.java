package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.VehicleReservationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private Long id;
    private String licenseNumber;
    private VehicleReservationStatus vehicleReservationStatus;
    private String email;
    private Date creationDate;
    private Date returnDate;
}
