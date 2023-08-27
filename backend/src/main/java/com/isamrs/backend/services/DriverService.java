package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Driver;
import com.isamrs.backend.repositories.DriverRepository;


@Service
public class DriverService {
    
    @Autowired
    DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id){
        return driverRepository.findById(id);

    }

    public Driver saveDriver(Driver dr){
        return driverRepository.save(dr);
    }

    public boolean deleteDriverById(Long id){
        Optional<Driver> existing = driverRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        driverRepository.delete(existing.get());
        return true;
    }

    public Driver updateDriver(Driver driv){
        //TODO
        return driv;
    }

}
