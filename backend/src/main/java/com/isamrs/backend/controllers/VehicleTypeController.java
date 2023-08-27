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

import com.isamrs.backend.DTO.VehicleTypeDTO;
import com.isamrs.backend.models.VehicleType;
import com.isamrs.backend.services.VehicleTypeService;


@RestController
@RequestMapping(value = "/api/vehicletype", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes(){

        List<VehicleType> vts = vehicleTypeService.getAllVehicleTypes();

        //Convert to DTO's
        List<VehicleTypeDTO> vtDTOs = new ArrayList<VehicleTypeDTO>();
        for (VehicleType vehicletype : vts) {
            vtDTOs.add(new VehicleTypeDTO(vehicletype));
        }

        return new ResponseEntity<>(vtDTOs, HttpStatus.OK);

    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VehicleTypeDTO> getVehicleTypeById(@PathVariable Long id){
		
		Optional<VehicleType> vt = vehicleTypeService.getVehicleTypeById(id);
		
		if (vt != null) {
			return new ResponseEntity<>(new VehicleTypeDTO(vt.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<VehicleTypeDTO> saveVehicleType(@RequestBody VehicleTypeDTO vtDTO) throws Exception {


        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(vtDTO.getId());
        vehicleType.setName(vtDTO.getName());
        vehicleType.setPriceKm(vtDTO.getPriceKm());

        vehicleTypeService.saveVehicleType(vehicleType);
        return new ResponseEntity<>(new VehicleTypeDTO(vehicleType),HttpStatus.CREATED);

	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<VehicleTypeDTO> deleteVehicleTypeById(@PathVariable Long id){
		
		Optional<VehicleType> vt = vehicleTypeService.getVehicleTypeById(id);
		
		if (vt != null) {
            vehicleTypeService.deleteVehicleTypeById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
