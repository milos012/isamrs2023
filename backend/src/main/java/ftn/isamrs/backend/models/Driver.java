package ftn.isamrs.backend.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User{

    @Column(name = "active",nullable = false)
    private Boolean active;

    // @Column(name = "drives",nullable = false)
    // private List<Drive> drives;

    // //OnetoOne
    // @Column(name = "drives",nullable = false)
    // private Vehicle vehicle;

    
}
