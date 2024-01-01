package com.randeu.randeu.controller;

import com.randeu.randeu.model.Address;
import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.model.StatusType;
import com.randeu.randeu.service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
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

    @RequestMapping(value = "/approve-appointment/{apid}", method = RequestMethod.GET)
    public RedirectView approveAppointment(@PathVariable(name = "apid") int apid){
        appointmentService.setStatusType(apid, "APPROVED");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/appointments");
        return redirectView;
    }

    @RequestMapping(value = "/reject-appointment/{apid}", method = RequestMethod.GET)
    public RedirectView rejectAppointment(@PathVariable(name = "apid") int apid){
        appointmentService.setStatusType(apid, "REJECTED");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/appointments");
        return redirectView;
    }

    @GetMapping(value = "/new-appointment")
    public RedirectView appointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/appointments");
        return redirectView;
    }

    @PostMapping(value = "/new-appointment")
    public String appointmentSubmit(@ModelAttribute Appointment appointment, Model model) {
        model.addAttribute("appointment", appointment);
        return "randeu";
    }

}
