package com.randeu.randeu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CoursesId implements Serializable {
    private static final long serialVersionUID = 8840780940491769271L;
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CoursesId entity = (CoursesId) o;
        return Objects.equals(this.personId, entity.personId) &&
                Objects.equals(this.courseId, entity.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, courseId);
    }

}