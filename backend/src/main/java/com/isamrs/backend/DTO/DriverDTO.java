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
public class DriverDTO extends UserDTO{

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
        this.active = driv.getActivated();

        //Mozda se ne vidi jer se kaci na id, a drive je podklasa usera(koristi id superklase)
        // this.drives = driv.getDrives();
    }
    
}
