package com.ezigo.CarRental.Dto;

import com.ezigo.CarRental.Models.VehicleReservation;
import lombok.Data;

import java.util.Date;

@Data
public class BillDto {
    private Long id;
    private float amount;
    private Date createdDate;
    private VehicleReservation vehicleReservation;
}
