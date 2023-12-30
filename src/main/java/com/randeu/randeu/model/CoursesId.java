package com.randeu.randeu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Embeddable
public class CoursesId implements Serializable {

    @Serial
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