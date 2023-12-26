package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Course {


    @Id
    @Column(name = "cid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "department", length = 60)
    private String department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "course")
    private Set<Courses> courses = new LinkedHashSet<>();

}
