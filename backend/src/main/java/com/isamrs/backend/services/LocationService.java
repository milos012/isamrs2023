package com.isamrs.backend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Location;
import com.isamrs.backend.repositories.LocationRepository;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id){
        return locationRepository.findById(id);

    }

    public Location saveLocation(Location loc){
        return locationRepository.save(loc);
    }

    public boolean deleteLocationById(Long id){
        Optional<Location> existing = locationRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        locationRepository.delete(existing.get());
        return true;
    }

    public Location updateLocation(Location loc){
        //TODO
        return loc;
    }
    
}

