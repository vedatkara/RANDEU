package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.io.Serializable;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Appointment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Appointment(Instant date, String subject, Integer duration, Address address,
                       Person student, Person lecturer, StatusType statusType) {
        this.date = date;
        this.subject = subject;
        this.duration = duration;
        this.address = address;
        this.student = student;
        this.lecturer = lecturer;
        this.statusType = statusType;
    }
}
