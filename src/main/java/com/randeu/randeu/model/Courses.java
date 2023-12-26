package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(CoursesId.class)
public class Courses {


    @EmbeddedId
    private CoursesId courseId;

    @EmbeddedId
    private CoursesId personId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "day", length = 15)
    private String day;

    @Column(name = "time")
    private Integer time;

    @Column(name = "duration")
    private Integer duration;

}
