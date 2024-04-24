package com.ezigo.CarRental.Repository;

import com.ezigo.CarRental.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {


    Optional<Bill> findById(Long billId);
}
