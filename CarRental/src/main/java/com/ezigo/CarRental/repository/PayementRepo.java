package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepo extends JpaRepository<Payment,Long> {

}