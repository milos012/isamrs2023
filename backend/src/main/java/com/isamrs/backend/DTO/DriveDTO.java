package com.isamrs.backend.DTO;

import java.time.LocalTime;
import java.util.List;

import com.isamrs.backend.enums.DriveStatus;
import com.isamrs.backend.models.Drive;
import com.isamrs.backend.models.Route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriveDTO {

    private Long id;
    private LocalTime pocetak;
    private LocalTime kraj;
    private Double ukupnaCena;

    //Mozda drivers? drive je manytoone so idk
    //TODO: passengers

    private List<Route> routes;
    private DriveStatus status;
    private Boolean babyFriendly;
    private Boolean petFriendly;

    public DriveDTO(Drive driv){
        this.id = driv.getId();
        this.pocetak = driv.getPocetak();
        this.kraj = driv.getKraj();
        this.ukupnaCena= driv.getUkupnaCena();
        
        this.routes = driv.getRoutes();
        this.status = driv.getStatus();
        this.babyFriendly = driv.getBabyFriendly();
        this.petFriendly = driv.getPetFriendly();
    }
    
}
