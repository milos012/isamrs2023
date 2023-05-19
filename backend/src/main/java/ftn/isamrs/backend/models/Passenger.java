package ftn.isamrs.backend.models;

import java.util.ArrayList;

import javax.persistence.*;


import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends User{

    @Column(name = "drives",nullable = false)
    private ArrayList<Drive> drives;

    // @Column(name = "favDrives",nullable = false)
    // private ArrayList<Drive> favDrives;

}
