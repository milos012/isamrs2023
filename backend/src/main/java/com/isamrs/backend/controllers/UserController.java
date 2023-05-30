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

import com.isamrs.backend.DTO.UserDTO;
import com.isamrs.backend.models.User;
import com.isamrs.backend.services.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        List<User> users = userService.getAllUsers();

        //Convert to DTO's
        List<UserDTO> uDTOs = new ArrayList<UserDTO>();
        for (User ad : users) {
            uDTOs.add(new UserDTO(ad));
        }

        return new ResponseEntity<>(uDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		
		Optional<User> user = userService.getUserById(id);
		
		if (user != null) {
			return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
