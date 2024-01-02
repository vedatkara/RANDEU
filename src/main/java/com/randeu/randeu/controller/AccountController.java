package com.randeu.randeu.controller;

import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping("account")
    public String account(Model model, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("name", loggedInUser.getName());
            model.addAttribute("surname", loggedInUser.getSurname());
            model.addAttribute("phone",loggedInUser.getPhone());
            model.addAttribute("email",loggedInUser.getEmail());
            model.addAttribute("department",loggedInUser.getDepartment());
            model.addAttribute("img",loggedInUser.getName().substring(0,1)+
                    loggedInUser.getSurname().substring(0,1));
        }
        else
            return "redirect:/login";

        return "account";
    }

    @PostMapping("/account")
    public String updatePhone(@RequestBody String newPhoneValue, HttpSession session){
        Person loggedInUser = (Person) session.getAttribute("loggedInUser");
        accountService.updatePhone(newPhoneValue,loggedInUser.getId());
        loggedInUser.setPhone(newPhoneValue);

        return "account";
    }

}
