package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    public CoursesId getCourseId() {
        return courseId;
    }

    public void setCourseId(CoursesId courseId) {
        this.courseId = courseId;
    }

    public CoursesId getPersonId() {
        return personId;
    }

    public void setPersonId(CoursesId personId) {
        this.personId = personId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
