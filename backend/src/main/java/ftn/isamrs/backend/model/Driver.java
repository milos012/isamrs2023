package ftn.isamrs.backend.model;

import java.util.List;

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

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Drive> drives;

    // //OnetoOne
    // @Column(name = "drives",nullable = false)
    // private Vehicle vehicle;

    
}
