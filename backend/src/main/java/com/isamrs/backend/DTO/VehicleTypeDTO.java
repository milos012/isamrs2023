package com.isamrs.backend.DTO;

import com.isamrs.backend.models.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTypeDTO {

    private Long id;
    private String name;
    private Long priceKm;

    public VehicleTypeDTO(VehicleType vt){
        this.id = vt.getId();
        this.name = vt.getName();
        this.priceKm = vt.getPriceKm();
    }
    
}
