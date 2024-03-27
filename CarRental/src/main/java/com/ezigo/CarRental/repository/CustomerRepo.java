package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findFirstByEmail(String email);
    Optional<Customer> findFirstByPassword(String password);
    Optional<Customer> findByEmailAndPassword(String email,String password);
}
