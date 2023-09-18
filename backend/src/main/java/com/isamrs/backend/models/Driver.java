package com.isamrs.backend.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver{

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

    @Column(name = "active",nullable = false)
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_driver_id",referencedColumnName = "id")
    private List<Drive> drives;

    // //OnetoOne
    // @Column(name = "drives",nullable = false)
    // private Vehicle vehicle;


    
}

