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

import com.isamrs.backend.DTO.PassengerDTO;
import com.isamrs.backend.models.Passenger;
import com.isamrs.backend.services.MailSenderService;
import com.isamrs.backend.services.PassengerService;



@RestController
@RequestMapping(value = "/api/passenger", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerController {
    
    @Autowired
    PassengerService passengerService;

    @Autowired
    MailSenderService mailService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<PassengerDTO>> getAllPassengers(){

        List<Passenger> ps = passengerService.getAllPassengers();

        //Convert to DTO's
        List<PassengerDTO> pDTOs = new ArrayList<PassengerDTO>();
        for (Passenger passenger : ps) {
            pDTOs.add(new PassengerDTO(passenger));
        }

        return new ResponseEntity<>(pDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id){
		
		Optional<Passenger> rt = passengerService.getPassengerById(id);
		
		if (rt != null) {
			return new ResponseEntity<>(new PassengerDTO(rt.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<PassengerDTO> deletePassengerById(@PathVariable Long id){
		
		Optional<Passenger> vh = passengerService.getPassengerById(id);
		
		if (vh != null) {
            passengerService.deletePassengerById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PassengerDTO> savePassenger(@RequestBody PassengerDTO pDTO) throws Exception {

        Passenger pass = new Passenger();

        pass.setId(pDTO.getId());
        pass.setFname(pDTO.getFname());
        pass.setLname(pDTO.getLname());
        pass.setEmail(pDTO.getEmail());
        pass.setPassword(pDTO.getPassword());
        pass.setPhoneNumber(pDTO.getPhoneNumber());
        pass.setImgUrl(pDTO.getImgUrl());
        pass.setAddress(pDTO.getAddress());
        pass.setBlocked(pDTO.getBlocked());
        pass.setActivated(false);
        
        //pass.setDrives(pDTO.getDrives());

        passengerService.savePassenger(pass);

        //Sending mail
        String subject = "ISAMRS Account activation";
        String body = "Your account has been sucessfully created but it will remain unactive. To activate it please follow the link below: " + "http://127.0.0.1:5173/activation";

        mailService.sendSimpleEmail(pass.getEmail(), subject, body);


		return new ResponseEntity<>(new PassengerDTO(pass), HttpStatus.CREATED);
	}
}
