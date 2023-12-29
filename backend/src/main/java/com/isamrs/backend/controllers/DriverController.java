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

import com.isamrs.backend.DTO.DriverDTO;
import com.isamrs.backend.models.Driver;
import com.isamrs.backend.services.DriverService;

@RestController
@RequestMapping(value = "/api/driver", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<DriverDTO>> getAllDrivers(){

        List<Driver> drivers = driverService.getAllDrivers();

        //Convert to DTO's
        List<DriverDTO> driverDTOs = new ArrayList<DriverDTO>();
        for (Driver d : drivers) {
            driverDTOs.add(new DriverDTO(d));
        }

        return new ResponseEntity<>(driverDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id){
		
		Optional<Driver> driver = driverService.getDriverById(id);
		
		if (driver != null) {
			return new ResponseEntity<>(new DriverDTO(driver.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DriverDTO> saveDriver(@RequestBody DriverDTO driverDTO) throws Exception {

        Driver driver = new Driver();


        driver.setId(driverDTO.getId());
        driver.setFname(driverDTO.getFname());
        driver.setLname(driverDTO.getLname());
        driver.setEmail(driverDTO.getEmail());
        driver.setPassword(driverDTO.getPassword());
        driver.setPhoneNumber(driverDTO.getPhoneNumber());
        driver.setImgUrl(driverDTO.getImgUrl());
        driver.setAddress(driverDTO.getAddress());
        driver.setBlocked(driverDTO.getBlocked());
        driver.setActivated(true);
        driver.setActive(false);
        
        //driver.setDrives(driverDTO.getDrives());
        
        driverService.saveDriver(driver);

        return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.CREATED);

		
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<DriverDTO> deleteDriverById(@PathVariable Long id){
		
		Optional<Driver> driver = driverService.getDriverById(id);
		
		if (driver != null) {
            driverService.deleteDriverById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
