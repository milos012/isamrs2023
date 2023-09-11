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

import com.isamrs.backend.DTO.VehicleDTO;
import com.isamrs.backend.models.Vehicle;
import com.isamrs.backend.services.VehicleService;


@RestController
@RequestMapping(value = "/api/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){

        List<Vehicle> vhs = vehicleService.getAllVehicles();

        //Convert to DTO's
        List<VehicleDTO> vhsDTOs = new ArrayList<VehicleDTO>();
        for (Vehicle v : vhs) {
            vhsDTOs.add(new VehicleDTO(v));
        }

        return new ResponseEntity<>(vhsDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id){
		
		Optional<Vehicle> rt = vehicleService.getVehicleById(id);
		
		if (rt != null) {
			return new ResponseEntity<>(new VehicleDTO(rt.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vhDTO) throws Exception {

        Vehicle vh = new Vehicle();
        vh.setId(vhDTO.getId());
        vh.setModel(vhDTO.getModel());
        vh.setRegistrationNumber(vhDTO.getRegistrationNumber());
        vh.setSlotNumber(vhDTO.getSlotNumber());
        vh.setBabyFriendly(vhDTO.getBabyFriendly());
        vh.setPetFriendly(vhDTO.getPetFriendly());

        //TODO dopuni sa join elementima

        vehicleService.saveVehicle(vh);

		return new ResponseEntity<>(new VehicleDTO(vh), HttpStatus.CREATED);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<VehicleDTO> deleteVehicleById(@PathVariable Long id){
		
		Optional<Vehicle> vh = vehicleService.getVehicleById(id);
		
		if (vh != null) {
            vehicleService.deleteVehicleById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
