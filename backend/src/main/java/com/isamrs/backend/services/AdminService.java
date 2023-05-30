package com.isamrs.backend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Admin;
import com.isamrs.backend.repositories.AdminRepository;



@Service
public class AdminService {

    @Autowired
    public AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    
    public Admin getAdminByUsername(String username){
        return adminRepository.findAdminByUsername(username);
    }

    public Optional<Admin> getAdminById(Long id){
        return adminRepository.findById(id);

    }

    public Admin saveAdmin(Admin a){
        return adminRepository.save(a);
    }

    public boolean deleteAdminById(Long id){
        Optional<Admin> existing = adminRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        adminRepository.delete(existing.get());
        return true;
    }

    public Admin updateAdmin(Admin a){
        //TODO
        return a;
    }
    
}
