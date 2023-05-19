package ftn.isamrs.backend.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vehicleType")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "priceKm",nullable = false)
    private Long priceKm;
    
}
