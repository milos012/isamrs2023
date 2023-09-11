package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Vehicle;
import com.isamrs.backend.repositories.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);

    }

    public Vehicle saveVehicle(Vehicle v){
        return vehicleRepository.save(v);
    }
    
    public boolean deleteVehicleById(Long id){
        Optional<Vehicle> existing = vehicleRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        vehicleRepository.delete(existing.get());
        return true;
    }

    public Vehicle updateVehicle(Vehicle vh){
        //TODO
        return vh;
    }

}
