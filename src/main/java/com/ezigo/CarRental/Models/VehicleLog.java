package com.ezigo.CarRental.Models;

import com.ezigo.CarRental.Enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLog {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    private VehicleStatus vehicleStatus;
    private String description;
    private Date creationDate;
}
