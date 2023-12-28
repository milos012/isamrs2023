package com.isamrs.backend.models;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Passenger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fname",nullable = false)
    private String fname;

    @Column(name = "lname",nullable = false)
    private String lname;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "imgUrl",nullable = false)
    private String imgUrl;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "blocked",nullable = false)
    private Boolean blocked;

    @Column(name = "activated",nullable = false)
    private Boolean activated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_passenger_id",referencedColumnName = "id")
    private List<Drive> drives;

    // @Column(name = "favDrives",nullable = false)
    // private ArrayList<Drive> favDrives;

}

