package com.randeu.randeu.dao;

import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.model.StatusType;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    @Query(value="SELECT * FROM appointment a WHERE a.student_id=:studentId",nativeQuery = true)
    List<Appointment> findAppointmentsByStudentId(int studentId);

    @Query(value="SELECT * FROM appointment a WHERE a.lecturer_id=:lecturerId",nativeQuery = true)
    List<Appointment> findAppointmentsByLecturerId(int lecturerId);

    @Modifying
    @Query(value= "UPDATE appointment a SET status_type=:statusType WHERE a.apid =:id",nativeQuery = true)
    void setStatusType(int id, StatusType statusType);

}
