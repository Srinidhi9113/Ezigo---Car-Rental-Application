package com.ezigo.CarRental.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "users")
    private List<VehicleReservation> vehicleReservationList ;


}
