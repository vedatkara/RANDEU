package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.io.Serializable;
import java.time.Instant;


@Entity
@Data
public class Appointment implements Serializable {


    @Id
    @Column(name = "apid", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "duration", nullable = false)
    private Integer duration;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Person student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Person lecturer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private StatusType statusType;

}
