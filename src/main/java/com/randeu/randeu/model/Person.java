package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("not null")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int appointmentId;
    private int scheduleId;
    private String password;
}
