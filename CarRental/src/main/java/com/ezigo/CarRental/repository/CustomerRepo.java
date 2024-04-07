package com.ezigo.CarRental.repository;

import com.ezigo.CarRental.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Person, String> {
    Optional<Person> findFirstByEmail(String email);
    Optional<Person> findFirstByPassword(String password);
    Optional<Person> findByEmailAndPassword(String email, String password);
}
