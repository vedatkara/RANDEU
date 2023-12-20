package com.randeu.randeu.controller;

import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.RandeuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandeuController {

    @Autowired
    RandeuService randeuService;

    @RequestMapping("appointments")
    public String appointments() {
        return "randeu";
    }

    @RequestMapping("calendar")
    public String calendar(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
        }
        return "calendar";
    }

    @RequestMapping("notifications")
    public String notifications(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
        }
        return "notifications";
    }

    @RequestMapping("account")
    public String defectDetails(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
        }
        return "account";
    }


}
