package com.isamrs.backend.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "geoLongitude",nullable = false)
    private String geoLongitude;

    @Column(name = "geoLatitude",nullable = false)
    private String geoLatitude;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_polaziste_id",referencedColumnName = "id")
    private List<Route> polazistaRuta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_odrediste_id",referencedColumnName = "id")
    private List<Route> odredistaRuta;

    
}

