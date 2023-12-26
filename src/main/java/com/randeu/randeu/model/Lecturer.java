package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Lecturer extends Person {


    @Id
    @Column(name = "address_id", nullable = false)
    private Integer id;

}
