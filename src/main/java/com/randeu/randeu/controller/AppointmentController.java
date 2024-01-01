package com.randeu.randeu.controller;

import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping("/appointments")
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
                model.addAttribute("appointment", new Appointment());
            }
            else {
                user = "lecturer";
                model.addAttribute("appointments", appointmentService.getLecturerAppointmentsById(id));
                model.addAttribute("appointment", new Appointment());
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
    public String appointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "redirect:/appointments";
    }

    @PostMapping(value = "/new-appointment")
    public ModelAndView appointmentSubmit(@ModelAttribute Appointment appointment, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();

        // Validate the appointment
        // Your validation logic here

        if (bindingResult.hasErrors()) {
            // If there are validation errors, set the view name and model attributes
            modelAndView.setViewName("redirect:/new-appointment");
            modelAndView.addObject("org.springframework.validation.BindingResult.appointment", bindingResult);
            modelAndView.addObject("appointment", appointment);
        } else {
            // If validation is successful, proceed to save the appointment or perform other actions
            // ...

            // Set the view name for the successful redirect
            modelAndView.setViewName("redirect:/appointments");
        }

        return modelAndView;
    }

}
