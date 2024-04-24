package com.ezigo.CarRental.Models;

import com.ezigo.CarRental.Enums.VehicleReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VehicleReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private VehicleReservationStatus vehicleReservationStatus;
    private Date creationDate;
    private Date returnDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//    @JoinTable(
//            name = "reservation_user",
//            joinColumns = @JoinColumn(name = "vehiclereservation_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    @JoinColumn(name = "user_id")
    private MyUser users;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "vehicleReservation",orphanRemoval = true)
//    private Bill bill;
}
