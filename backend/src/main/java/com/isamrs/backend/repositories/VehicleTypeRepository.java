package com.isamrs.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.backend.models.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long>{
    
}
