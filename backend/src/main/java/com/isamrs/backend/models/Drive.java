package com.isamrs.backend.models;


import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

import com.isamrs.backend.enums.DriveStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "drive")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drive {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pocetak",nullable = false)
    private LocalTime pocetak;

    @Column(name = "kraj",nullable = false)
    private LocalTime kraj;

    // startna tarifa + zbir cena svih ruta
    @Column(name = "ukupnaCena",nullable = false)
    private Double ukupnaCena;

    // Ne treba ManyToOne, samo OneToMany
    // @ManyToOne
    // @JoinColumn(name = "driver_id")
    // private Driver driver;

    //TODO
    // @ManyToMany(mappedBy = "drive")
    // private Set<Passenger> passengers;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name="fk_drive_id",referencedColumnName = "id")
    // private List<Route> routes;

    @Column(name = "status",nullable = false)
    private DriveStatus status;

    @Column(name = "babyFriendly",nullable = false)
    private Boolean babyFriendly;

    @Column(name = "petFriendly",nullable = false)
    private Boolean petFriendly;

    @Column(name = "polaziste",nullable = false)
    private String polaziste;

    @Column(name = "odrediste",nullable = false)
    private String odrediste;

    @Column(name = "datum",nullable = false)
    private String datum;

    
}

