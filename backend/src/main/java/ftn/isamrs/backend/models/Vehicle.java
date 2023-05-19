package ftn.isamrs.backend.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model",nullable = false)
    private String model;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "driver")
    private Driver driver;

    //OnetoMany ili ManytoOne ?
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vehicle")
    private VehicleType vehicleType;

    //Registracione tablice
    @Column(name = "registrationNumber",nullable = false)
    private String registrationNumber;

    // Broj mesta u vozilu
    @Column(name = "slotNumber",nullable = false)
    private String slotNumber;

    @Column(name = "babyFriendly",nullable = false)
    private Boolean babyFriendly;

    @Column(name = "petFriendly",nullable = false)
    private Boolean petFriendly;

    //Trenutna lokacija
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Location location;
}
