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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping("appointments")
    public String appointments(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            int id = loggedInUser.getId();

            //check whether user student or lecturer
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

    @RequestMapping(value = "/new-appointment/{date}/{subject}/{duration}/{address}/{student}/{lecturer}", method = RequestMethod.POST)
    public RedirectView newAppointment(@PathVariable(name = "date") Instant date,
                                       @PathVariable(name = "subject") String subject,
                                        @PathVariable(name = "duration") int duration,
                                       @PathVariable(name = "address") Address address,
                                       @PathVariable(name = "student") Person student,
                                       @PathVariable(name = "lecturer") Person lecturer) {

        Appointment appointment = new Appointment(date, subject, duration, address, student, lecturer, StatusType.PENDING);
        appointmentService.save(appointment);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/appointments");
        return redirectView;

    }
}
