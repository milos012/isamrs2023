package ftn.isamrs.backend.DTO;

import ftn.isamrs.backend.model.Location;
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

    public LocationDTO(Location loc){
        this.id = loc.getId();
        this.geoLatitude = loc.getGeoLatitude();
        this.geoLongitude = loc.getGeoLongitude();
    }
    
}
