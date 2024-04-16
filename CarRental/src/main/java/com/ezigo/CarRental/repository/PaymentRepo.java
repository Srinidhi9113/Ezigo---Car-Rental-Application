package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Bill;
import com.ezigo.CarRental.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
