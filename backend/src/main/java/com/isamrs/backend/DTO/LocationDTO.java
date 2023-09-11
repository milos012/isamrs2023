package com.isamrs.backend.DTO;


import java.util.List;

import com.isamrs.backend.models.Location;
import com.isamrs.backend.models.Route;
import com.isamrs.backend.models.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private Long id;
    private String geoLongitude;
    private String geoLatitude;
    private List<Route> polazistaRuta;
    private List<Route> odredistaRuta;
    private List<Vehicle> vehicles;

    public LocationDTO(Location loc){
        this.id = loc.getId();
        this.geoLatitude = loc.getGeoLatitude();
        this.geoLongitude = loc.getGeoLongitude();
        this.polazistaRuta = loc.getPolazistaRuta();
        this.odredistaRuta = loc.getOdredistaRuta();
        this.vehicles = loc.getVehicles();
    }
    
}

