package com.isamrs.backend.DTO;

import java.util.List;

import com.isamrs.backend.models.Drive;
import com.isamrs.backend.models.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO{

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phoneNumber;
    private String imgUrl;
    private String address;
    private Boolean blocked;
    private Boolean activated;
    private Boolean active;
    private List<Drive> drives;

    public DriverDTO(Driver driv){
        this.setId(driv.getId());
        this.setFname(driv.getFname());
        this.setLname(driv.getLname());
        this.setEmail(driv.getEmail());
        this.setPassword(driv.getPassword());
        this.setPhoneNumber(driv.getPhoneNumber());
        this.setImgUrl(driv.getImgUrl());
        this.setAddress(driv.getAddress());
        this.setBlocked(driv.getBlocked());
        this.setActivated(true);
        this.setActive(driv.getActive());

        this.setDrives(driv.getDrives());
    }
    
}
