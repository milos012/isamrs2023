package ftn.isamrs.backend.DTO;

import ftn.isamrs.backend.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Long id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String imgUrl;

    public AdminDTO(Admin a){
        this.id = a.getId();
        this.fname = a.getFname();
        this.lname = a.getLname();
        this.username = a.getUsername();
        this.password = a.getPassword();
        this.imgUrl = a.getImgUrl();
    }
    
}
