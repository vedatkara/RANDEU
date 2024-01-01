package com.randeu.randeu.dao;

import com.randeu.randeu.model.Courses;
import com.randeu.randeu.model.CoursesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Courses, CoursesId> {

    @Query(value="SELECT * FROM courses c WHERE c.person_id=:id",nativeQuery = true)
    List<Courses> findCoursesById(Integer id);



}
