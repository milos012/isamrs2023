package com.isamrs.backend.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User{

    @Column(name = "active",nullable = false)
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_driver_id",referencedColumnName = "id")
    private List<Drive> drives;

    // //OnetoOne
    // @Column(name = "drives",nullable = false)
    // private Vehicle vehicle;

    
}

