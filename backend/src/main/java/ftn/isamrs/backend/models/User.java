package ftn.isamrs.backend.models;

import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

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

    //TODO da li treba security uopste?

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "user_role",
    //         joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    //         inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    // private List<Role> roles;

    // @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    // private Authority authority;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    // private List<Drive> drives;
    
}
