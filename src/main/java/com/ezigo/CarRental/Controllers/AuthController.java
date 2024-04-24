package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.SignInDto;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public String processSignup(@ModelAttribute SignInDto signInDto){
        MyUser user = new MyUser();
        user.setUsername(signInDto.getUsername());
        user.setPassword(passwordEncoder.encode(signInDto.getPassword()));
        user.setEmail(signInDto.getEmail());
        user.setRole("USER");
        user.setPhoneNumber(signInDto.getPhoneNumber());
        userRepo.save(user);
        System.out.println("User entered successfully");
        return "redirect:/login";
    }
}
