package com.randeu.randeu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table
public class Notification {

    @Id
    @Column(name = "nid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "message", nullable = false, length = 300)
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "is_read", nullable = false)
    private Byte isRead;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pid", nullable = false)
    @JsonIgnore /* Prevents recursive call */
    private Person pid;

    public Notification(String message, LocalDate createdAt, Byte isRead, Person pid) {
        this.message = message;
        this.createdAt = createdAt;
        this.isRead = isRead;
        this.pid = pid;
    }
}
