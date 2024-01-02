package com.randeu.randeu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table
public class Notification {

    @Id
    @Column(name = "nid", nullable = false)
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

}
