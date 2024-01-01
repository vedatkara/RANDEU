package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Person", schema = "randeu")
@DiscriminatorValue("not null")
public class Person implements Serializable {


    @Id
    @Column(name = "pid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "department", length = 60)
    private String department;

    @Column(name = "appointment_id", nullable = false)
    private Integer appointmentId;

    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;

    @Column(name = "address_id")
    private Integer addressId;

    @OneToMany(mappedBy = "lecturer")
    private Set<Appointment> lAppointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<Appointment> sAppointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<Courses> courses = new LinkedHashSet<>();

}
