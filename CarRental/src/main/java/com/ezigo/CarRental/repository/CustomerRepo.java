package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
