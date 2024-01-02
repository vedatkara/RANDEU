package com.randeu.randeu.controller;

import com.randeu.randeu.model.Notification;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.NotificationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;
    @RequestMapping("notifications")
    public String notifications(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
            model.addAttribute("notifications", notificationService.getNotificationsByPid(loggedInUser.getId()));
        }
        else
            return "redirect:/login";

        return "notifications";
    }

    @RequestMapping("/read-notification/{nid}")
    public String readNotification(@PathVariable(name = "nid") Integer nid) {
        notificationService.update(nid);
        return "redirect:/notifications";
    }
}
