package com.isamrs.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.backend.models.Drive;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Long>{
    
}
