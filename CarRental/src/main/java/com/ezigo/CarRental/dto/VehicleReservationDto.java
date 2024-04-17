package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.enums.VehicleReservationStatus;
import com.ezigo.CarRental.models.Bill;
import com.ezigo.CarRental.models.User;
import com.ezigo.CarRental.models.Vehicle;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class VehicleReservationDto {
    private Long id;
    private VehicleReservationStatus vehicleReservationStatus;
    private Date creationDate;
    private Date returnDate;
    private User users;
    private Vehicle vehicle;
}
