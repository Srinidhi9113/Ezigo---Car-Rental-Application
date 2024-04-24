package com.ezigo.CarRental.Dto;

import lombok.Data;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Data
public class SignInDto {
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
}
