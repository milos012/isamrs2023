package com.isamrs.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isamrs.backend.DTO.LocationDTO;
import com.isamrs.backend.models.Location;
import com.isamrs.backend.services.LocationService;


@RestController
@RequestMapping(value = "/api/location", produces = MediaType.APPLICATION_JSON_VALUE)
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<LocationDTO>> getAllLocations(){

        List<Location> locations = locationService.getAllLocations();

        //Convert to DTO's
        List<LocationDTO> locDTOs = new ArrayList<LocationDTO>();
        for (Location loc : locations) {
            locDTOs.add(new LocationDTO(loc));
        }

        return new ResponseEntity<>(locDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id){
		
		Optional<Location> loc = locationService.getLocationById(id);
		
		if (loc != null) {
			return new ResponseEntity<>(new LocationDTO(loc.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locDTO) throws Exception {

        Location location = new Location();
        location.setId(locDTO.getId());
        location.setGeoLatitude(locDTO.getGeoLatitude());
        location.setGeoLongitude(locDTO.getGeoLongitude());
        location.setPolazistaRuta(locDTO.getPolazistaRuta());
        location.setOdredistaRuta(locDTO.getOdredistaRuta());
        location.setVehicles(locDTO.getVehicles());

        locationService.saveLocation(location);

		return new ResponseEntity<>(new LocationDTO(location), HttpStatus.CREATED);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<LocationDTO> deleteLocationById(@PathVariable Long id){
		
		Optional<Location> loc = locationService.getLocationById(id);
		
		if (loc != null) {
            locationService.deleteLocationById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}

