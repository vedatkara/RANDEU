package com.randeu.randeu.controller;

import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
        }
        return "randeu";
    }
}
