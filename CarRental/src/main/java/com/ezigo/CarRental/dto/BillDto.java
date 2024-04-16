package com.ezigo.CarRental.dto;

import com.ezigo.CarRental.models.VehicleReservation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class BillDto {
    private Long id;
    private float amount;
    private Date createdDate;
    private VehicleReservation vehicleReservation;
}
