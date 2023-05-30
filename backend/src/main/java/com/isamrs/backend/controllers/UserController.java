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
import com.isamrs.backend.services.MailSenderService;
import com.isamrs.backend.services.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MailSenderService mailService;


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

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) throws Exception {

        // Creating user
        User user = new User();

        user.setId(userDTO.getId());
        user.setFname(userDTO.getFname());
        user.setLname(userDTO.getLname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setImgUrl(userDTO.getImgUrl());
        user.setAddress(userDTO.getAddress());
        user.setBlocked(userDTO.getBlocked());
        user.setActivated(false);

        userService.saveUser(user);

        //Sending mail
        String subject = "ISAMRS Account activation";
        String body = "Your account has been sucessfully created but it will remain unactive. To activate it please follow the link below: " + "http://127.0.0.1:5173/activation";

        mailService.sendSimpleEmail(user.getEmail(), subject, body);

		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
    
}
