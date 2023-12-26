package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adid;

    private String campus;

    @Column(name = "fac_building")
    private String facBuilding;
    @Column(name = "room_no")
    private String roomNo;

    @OneToMany(mappedBy = "address")
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Course> courses = new LinkedHashSet<>();

}
