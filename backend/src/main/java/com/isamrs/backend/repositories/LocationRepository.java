package com.isamrs.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.backend.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    
}

