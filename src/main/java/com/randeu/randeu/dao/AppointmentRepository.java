package com.randeu.randeu.dao;

import com.randeu.randeu.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value="SELECT * FROM appointment a WHERE a.student_id=:studentId",nativeQuery = true)
    List<Appointment> findAppointmentsByStudentId(int studentId);

}
