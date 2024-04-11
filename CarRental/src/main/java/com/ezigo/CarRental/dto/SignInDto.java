package com.ezigo.CarRental.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String name;
    private String email;
    private String phoneNo;
    private String username;
    private String password;
}
