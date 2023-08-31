package com.isamrs.backend.DTO;

import java.time.LocalTime;

import com.isamrs.backend.models.Route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    private Long id;
    private LocalTime pocetak;
    private LocalTime kraj;
    private Double kilometraza;
    private Double procenjenoVreme;
    private Double cena;

    public RouteDTO(Route r){
        this.id = r.getId();
        this.pocetak = r.getPocetak();
        this.kraj = r.getKraj();
        this.kilometraza = r.getKilometraza();
        this.procenjenoVreme = r.getProcenjenoVreme();
        this.cena = r.getCena();
    }
    
}
