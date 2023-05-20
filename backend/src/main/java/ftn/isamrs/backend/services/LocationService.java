package ftn.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isamrs.backend.model.Location;
import ftn.isamrs.backend.repository.LocationRepository;

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
