package com.randeu.randeu.model;

import java.io.Serializable;

public class CoursesId implements Serializable {
    private int courseId;
    private int personId;

    public CoursesId(int courseId, int personId) {
        this.courseId = courseId;
        this.personId = personId;
    }
}
