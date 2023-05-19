package ftn.isamrs.backend.models;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import ftn.isamrs.backend.enums.DriveStatus;
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

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToMany(mappedBy = "drive")
    private Set<Passenger> passengers;

    @OneToMany(mappedBy = "drive", cascade = CascadeType.ALL)
    private List<Route> routes;

    @Column(name = "status",nullable = false)
    private DriveStatus status;

    @Column(name = "babyFriendly",nullable = false)
    private Boolean babyFriendly;

    @Column(name = "petFriendly",nullable = false)
    private Boolean petFriendly;

    
}
