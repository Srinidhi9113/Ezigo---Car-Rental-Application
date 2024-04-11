package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.LoginDto;
import com.ezigo.CarRental.dto.SignInDto;
import com.ezigo.CarRental.models.User;
import com.ezigo.CarRental.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepo userRepo;

    @Autowired
    public AuthService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public boolean findUserWithEmail(String email){
        Optional<User> user = userRepo.findFirstByEmail(email);
        return user.isPresent();
    }

    public static String hashPassword(String password) throws  NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());

        // Convert byte array to hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean verifyPassword(String enteredPassword, String storedHashedPassword) throws NoSuchAlgorithmException {
        String hashedEnteredPassword = hashPassword(enteredPassword);
        return hashedEnteredPassword.equals(storedHashedPassword);
    }

    public SignInDto insertUserToDB(SignInDto signInDto) throws NoSuchAlgorithmException {
        User newUser = new User();
        newUser.setName(signInDto.getName());
        newUser.setPhoneNo(signInDto.getPhoneNo());
        newUser.setEmail(signInDto.getEmail());
        newUser.setUsername(signInDto.getUsername());
        String encodedPassword = hashPassword(signInDto.getPassword());
        newUser.setPassword((encodedPassword));

        User user = userRepo.save(newUser);

        SignInDto newSignIn = new SignInDto();
        signInDto.setEmail(user.getEmail());
        return newSignIn;

    }

    public boolean loginUser(LoginDto loginDto) throws NoSuchAlgorithmException {
       Optional<User> user = userRepo.findByEmailAndPassword(loginDto.getEmail(),hashPassword(loginDto.getPassword()));
        return user.isPresent();
    }


}
