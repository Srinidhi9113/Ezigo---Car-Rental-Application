package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {

    List<Payment> findAllByEmailEquals(String email);

}
