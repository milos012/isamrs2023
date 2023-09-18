package com.isamrs.backend.DTO;

import java.util.List;

import com.isamrs.backend.models.Drive;
import com.isamrs.backend.models.Passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO{

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phoneNumber;
    private String imgUrl;
    private String address;
    private Boolean blocked;
    private List<Drive> drives;

    public PassengerDTO(Passenger p){
        this.setId(p.getId());
        this.setFname(p.getFname());
        this.setLname(p.getLname());
        this.setEmail(p.getEmail());
        this.setPassword(p.getPassword());
        this.setPhoneNumber(p.getPhoneNumber());
        this.setImgUrl(p.getImgUrl());
        this.setAddress(p.getAddress());
        this.setBlocked(p.getBlocked());

        this.setDrives(p.getDrives());

    }
    
}
