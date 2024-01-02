package com.randeu.randeu.controller;

import com.randeu.randeu.model.Appointment;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.CalendarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @RequestMapping("calendar")
    public String calendar(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
            int id = loggedInUser.getId();

            model.addAttribute("courses", calendarService.getCourses(id));
        }
        else
            return "redirect:/login";

        return "calendar";
    }

}
