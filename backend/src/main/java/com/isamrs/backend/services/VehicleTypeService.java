package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Admin;
import com.isamrs.backend.models.VehicleType;
import com.isamrs.backend.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }
    
    public Optional<VehicleType> getVehicleTypeById(Long id){
        return vehicleTypeRepository.findById(id);

    }

    public VehicleType saveVehicleType(VehicleType vt){
        return vehicleTypeRepository.save(vt);
    }

    public boolean deleteVehicleTypeById(Long id){
        Optional<VehicleType> existing = vehicleTypeRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        vehicleTypeRepository.delete(existing.get());
        return true;
    }

    public VehicleType updaVehicleType(VehicleType vt){
        //TODO
        return vt;
    }

    
}
