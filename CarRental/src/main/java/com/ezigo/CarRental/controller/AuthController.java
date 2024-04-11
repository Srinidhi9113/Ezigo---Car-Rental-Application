package com.ezigo.CarRental.controller;

import com.ezigo.CarRental.dto.LoginDto;
import com.ezigo.CarRental.dto.SignInDto;
import com.ezigo.CarRental.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signInUser(@RequestBody  SignInDto signInDto) throws NoSuchAlgorithmException {
        String email = signInDto.getEmail();
        if(!authService.findUserWithEmail(email)){
            SignInDto temp = authService.insertUserToDB(signInDto);
            if(temp != null) return new ResponseEntity<>("Sign Up Successful !!", HttpStatus.CREATED);
            else return new ResponseEntity<>("Could not create account",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("User with email already exits",HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        if(authService.loginUser(loginDto)){
            return new ResponseEntity<>("Login successful !",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("No such user !",HttpStatus.BAD_REQUEST);
    }
}
