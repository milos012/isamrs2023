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


import com.isamrs.backend.DTO.DriveDTO;
import com.isamrs.backend.models.Drive;
import com.isamrs.backend.services.DriveService;

@RestController
@RequestMapping(value = "/api/drive", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriveController {

    @Autowired
    DriveService driveService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<DriveDTO>> getAllDrives(){

        List<Drive> drives = driveService.getAllDrives();

        //Convert to DTO's
        List<DriveDTO> driveDTOs = new ArrayList<DriveDTO>();
        for (Drive d : drives) {
            driveDTOs.add(new DriveDTO(d));
        }

        return new ResponseEntity<>(driveDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DriveDTO> getDriveById(@PathVariable Long id){
		
		Optional<Drive> drive = driveService.getDriveById(id);
		
		if (drive != null) {
			return new ResponseEntity<>(new DriveDTO(drive.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DriveDTO> saveDrive(@RequestBody DriveDTO driveDTO) throws Exception {

        Drive drive = new Drive();
        drive.setId(driveDTO.getId());
        drive.setPocetak(driveDTO.getPocetak());
        drive.setKraj(driveDTO.getKraj());
        drive.setUkupnaCena(driveDTO.getUkupnaCena());

        //passengers i mozda drivers

        // drive.setRoutes(driveDTO.getRoutes());
        drive.setStatus(driveDTO.getStatus());
        drive.setBabyFriendly(driveDTO.getBabyFriendly());
        drive.setPetFriendly(driveDTO.getPetFriendly());
        drive.setPolaziste(driveDTO.getPolaziste());
        drive.setOdrediste(driveDTO.getOdrediste());
        drive.setDatum(driveDTO.getDatum());

        driveService.saveDrive(drive);

        return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.CREATED);

		
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<DriveDTO> deleteDriveById(@PathVariable Long id){
		
		Optional<Drive> drive = driveService.getDriveById(id);
		
		if (drive != null) {
            driveService.deleteDriveById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
