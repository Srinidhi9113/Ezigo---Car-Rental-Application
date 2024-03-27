package com.ezigo.CarRental.dto;

import lombok.Data;

@Data
public class SignupCustomerDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNo;
    private String password;


}
