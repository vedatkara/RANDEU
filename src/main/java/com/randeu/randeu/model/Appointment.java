package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private String subject;

    @OneToOne
    @JoinColumn(name = "addressId",insertable = false,updatable = false)
    private Address address;
    private int addressId;

    private int duration;
    private int studentId;
    private int lecturerId;
}
