package com.randeu.randeu.service;

import com.randeu.randeu.dao.CalendarRepository;
import com.randeu.randeu.model.Courses;
import com.randeu.randeu.model.CoursesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    public List<Courses> getCourses(Integer id) {return calendarRepository.findCoursesById(id);}

}
