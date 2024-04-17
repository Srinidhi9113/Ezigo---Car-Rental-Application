package com.ezigo.CarRental.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNo;
    private String username;
    private String password;
    private String email;

    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "users")
    private List<VehicleReservation> vehicleReservationList ;


}
