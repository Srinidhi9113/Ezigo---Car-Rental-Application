package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
