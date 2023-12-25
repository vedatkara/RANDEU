package com.randeu.randeu.service;

import com.randeu.randeu.dao.AppointmentRepository;
import com.randeu.randeu.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<List<Appointment>> getLecturerAppointmentsById(int id){
        try{
            return new ResponseEntity<>(appointmentRepository.findAppointmentsByLecturerId(id), HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
}
