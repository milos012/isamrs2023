package com.isamrs.backend.models;

import java.util.Set;

import javax.persistence.*;


import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends User{

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "passenger_drive",
            joinColumns = {@JoinColumn(name = "passenger_id")},
            inverseJoinColumns = {@JoinColumn(name = "drive_id")}
    )
    private Set<Drive> drives;

    // @Column(name = "favDrives",nullable = false)
    // private ArrayList<Drive> favDrives;

}

