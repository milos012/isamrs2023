package ftn.isamrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isamrs.backend.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    
}
