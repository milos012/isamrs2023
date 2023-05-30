package com.isamrs.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.backend.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    Admin findAdminByUsername(String username);
    
}
