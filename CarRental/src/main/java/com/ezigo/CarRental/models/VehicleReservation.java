package com.ezigo.CarRental.models;

import com.ezigo.CarRental.enums.VehicleReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

    @OneToMany
    @JoinTable(
            name = "reservation_user",
            joinColumns = @JoinColumn(name = "vehiclereservation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    private Bill bill;
}
