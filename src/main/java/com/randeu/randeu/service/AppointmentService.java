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

    public ResponseEntity<List<Appointment>> getAppointments(int id){
        try{
            return new ResponseEntity<>(appointmentRepository.findAppointmentsByStudentId(id), HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
}
