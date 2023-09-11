package com.isamrs.backend.DTO;

import com.isamrs.backend.models.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;
    private String model;
    private String registrationNumber;
    private String slotNumber;
    private Boolean babyFriendly;
    private Boolean petFriendly;

    //TODO dodaj ostale koji su join

    public VehicleDTO(Vehicle v){
        this.id = v.getId();
        this.model = v.getModel();
        this.registrationNumber = v.getRegistrationNumber();
        this.slotNumber = v.getSlotNumber();
        this.babyFriendly = v.getBabyFriendly();
        this.petFriendly = v.getPetFriendly();
    }
    
}
