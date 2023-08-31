package com.isamrs.backend.models;

import java.time.LocalTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pocetak",nullable = false)
    private LocalTime pocetak;

    @Column(name = "kraj",nullable = false)
    private LocalTime kraj;

    //Ne treba manytoone, samo onetomany u Location?
    // @Column(name = "polaziste",nullable = false, unique = true)
    // private Location polaziste;

    // @Column(name = "odrediste",nullable = false, unique = true)
    // private Location odrediste;
    
    @Column(name = "kilometraza",nullable = false)
    private Double kilometraza;

    // vreme u minutima
    @Column(name = "procenjenoVreme")
    private Double procenjenoVreme;

    //Cena po putanji: kilometraza * cena po km (VehicleType)
    @Column(name = "cena",nullable = false)
    private Double cena;

    // Ne treba manytoone, samo onetomay u pravoj klasi
    // @ManyToOne
    // @JoinColumn(name = "drive_id")
    // private Drive drive;
}

