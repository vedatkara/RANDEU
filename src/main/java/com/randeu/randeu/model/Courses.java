package com.randeu.randeu.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(CoursesId.class)
public class Courses {

    @Id
    private int personId;

    @Id
    private int courseId;
}
