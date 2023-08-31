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

import com.isamrs.backend.DTO.RouteDTO;
import com.isamrs.backend.DTO.WorkingHoursDTO;
import com.isamrs.backend.models.WorkingHours;
import com.isamrs.backend.services.WorkingHoursService;


@RestController
@RequestMapping(value = "/api/workinghours", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkingHoursController {

    @Autowired
    WorkingHoursService workingHoursService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<WorkingHoursDTO>> getAllWorkingHours(){

        List<WorkingHours> whs = workingHoursService.getAllWorkingHours();

        //Convert to DTO's
        List<WorkingHoursDTO> whsDTOs = new ArrayList<WorkingHoursDTO>();
        for (WorkingHours w : whs) {
            whsDTOs.add(new WorkingHoursDTO(w));
        }

        return new ResponseEntity<>(whsDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<WorkingHoursDTO> getWorkingHoursById(@PathVariable Long id){
		
		Optional<WorkingHours> rt = workingHoursService.getWorkingHoursById(id);
		
		if (rt != null) {
			return new ResponseEntity<>(new WorkingHoursDTO(rt.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<WorkingHoursDTO> saveWorkingHours(@RequestBody WorkingHoursDTO whDTO) throws Exception {


        WorkingHours wh = new WorkingHours();

        wh.setId(whDTO.getId());
        wh.setStart(whDTO.getStart());
        wh.setEnd(whDTO.getEnd());
        wh.setDrivers(whDTO.getDrivers());

        workingHoursService.saveWorkingHours(wh);

		return new ResponseEntity<>(new WorkingHoursDTO(wh), HttpStatus.CREATED);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<RouteDTO> deleteWorkingHoursById(@PathVariable Long id){
		
		Optional<WorkingHours> wh = workingHoursService.getWorkingHoursById(id);
		
		if (wh != null) {
            workingHoursService.deleteWorkingHoursById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
