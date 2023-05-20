package ftn.isamrs.backend.controllers;

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

import ftn.isamrs.backend.DTO.AdminDTO;
import ftn.isamrs.backend.model.Admin;
import ftn.isamrs.backend.services.AdminService;

@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<AdminDTO>> getAllAdmins(){

        List<Admin> admins = adminService.getAllAdmins();

        //Convert to DTO's
        List<AdminDTO> aDTOs = new ArrayList<AdminDTO>();
        for (Admin ad : admins) {
            aDTOs.add(new AdminDTO(ad));
        }

        return new ResponseEntity<>(aDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id){
		
		Optional<Admin> admin = adminService.getAdminById(id);
		
		if (admin != null) {
			return new ResponseEntity<>(new AdminDTO(admin.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<AdminDTO> saveAdmin(@RequestBody AdminDTO adminDTO) throws Exception {
        Admin ad = new Admin();

        ad.setId(adminDTO.getId());
        ad.setFname(adminDTO.getFname());
        ad.setLname(adminDTO.getLname());
        ad.setUsername(adminDTO.getUsername());
        ad.setPassword(adminDTO.getPassword());
        ad.setImgUrl(adminDTO.getImgUrl());

        adminService.saveAdmin(ad);

		return new ResponseEntity<>(new AdminDTO(ad), HttpStatus.CREATED);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<AdminDTO> deleteAdminById(@PathVariable Long id){
		
		Optional<Admin> ad = adminService.getAdminById(id);
		
		if (ad != null) {
            adminService.deleteAdminById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
