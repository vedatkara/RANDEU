package com.randeu.randeu.controller;

import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.model.StatusType;
import com.randeu.randeu.service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping
    public String appointments(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            int id = loggedInUser.getId();

            //check if user student or lecturer
            int first_digit = Integer.parseInt(Integer.toString(id).substring(0, 1));
            String user = "";
            if (first_digit == 2) {
                user = "student";
                model.addAttribute("appointments", appointmentService.getStudentAppointmentsById(id));
            }
            else {
                user = "lecturer";
                model.addAttribute("appointments", appointmentService.getLecturerAppointmentsById(id));
            }
            model.addAttribute("user", user);
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());

        }
        return "randeu";
    }

    @RequestMapping(value = "/approve-appointment", method = RequestMethod.POST)
    public String approveAppointment(Model Model, @ModelAttribute("appointment") Appointment appointment){
        appointmentService.setStatusType(appointment.getId(), StatusType.APPROVED);
        return "redirect:/appointments";
    }
}
