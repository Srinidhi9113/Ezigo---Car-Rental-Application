package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.CarType;
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
    private Long Id;
    private String licenseNumber;
    private CarType carType;
    private String description;
    private Date creationDate;
}
