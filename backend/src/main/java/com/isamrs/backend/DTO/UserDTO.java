package com.isamrs.backend.DTO;

import com.isamrs.backend.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phoneNumber;
    private String imgUrl;
    private String address;
    private Boolean blocked;

    public UserDTO(User u){
        this.id = u.getId();
        this.fname = u.getFname();
        this.lname = u.getLname();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.phoneNumber = u.getPhoneNumber();
        this.imgUrl = u.getImgUrl();
        this.address = u.getAddress();
        this.blocked = u.getBlocked();
    }
    
}
