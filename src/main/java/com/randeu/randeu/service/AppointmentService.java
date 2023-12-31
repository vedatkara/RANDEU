package com.randeu.randeu.service;

import com.randeu.randeu.dao.AppointmentRepository;
import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Notification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    public List<Appointment> getStudentAppointmentsById(int id){
        try{
            return appointmentRepository.findAppointmentsByStudentId(id);

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Appointment> getLecturerAppointmentsById(int id){
        try{
            return appointmentRepository.findAppointmentsByLecturerId(id);

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void setStatusType(int id, String statusType) {
        appointmentRepository.setStatusType(id, statusType);
    }


    @Transactional
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment findAppointmentById(Integer id) {
        return appointmentRepository.findAppointmentById(id);
    }
}
