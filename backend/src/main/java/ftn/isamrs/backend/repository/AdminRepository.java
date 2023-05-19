package ftn.isamrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isamrs.backend.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
