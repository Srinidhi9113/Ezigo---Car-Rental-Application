package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
import com.ezigo.CarRental.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicleLog")
public class VehicleLog {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private Vehicle vehicle;
    private String description;
    private Date creationDate;
}
