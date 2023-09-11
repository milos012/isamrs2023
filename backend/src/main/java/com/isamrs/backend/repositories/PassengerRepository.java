package com.isamrs.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.backend.models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{
    
}
