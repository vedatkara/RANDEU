package com.randeu.randeu.model;

import java.io.Serializable;

public class CoursesId implements Serializable {
    private int course_id;
    private int person_id;

    public CoursesId(int course_id, int person_id) {
        this.course_id = course_id;
        this.person_id = person_id;
    }
}
