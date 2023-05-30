package com.isamrs.backend.models;

import java.time.LocalTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "workingHour")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start",nullable = false)
    private LocalTime start;

    @Column(name = "end",nullable = false)
    private LocalTime end;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workingHour")
    // @Column(name = "driver",nullable = false)
    private Driver driver;
    
}

