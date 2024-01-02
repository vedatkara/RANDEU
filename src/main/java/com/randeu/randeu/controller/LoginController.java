package com.randeu.randeu.controller;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }

    @RequestMapping("/randeu")
    public String userSignIn(@ModelAttribute Person person, Model model, HttpSession session){
        ResponseEntity<Person> responseEntity = loginService.authenticate(person.getEmail(), person.getPassword());
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();

        if(statusCode == HttpStatus.OK) {//The person exists.
            Person user = responseEntity.getBody();
            model.addAttribute("name", user.getName());
            model.addAttribute("surname", user.getSurname());
            // Keep the session info
            session.setAttribute("loggedInUser", user);
            return "redirect:/appointments";
        }else if(statusCode == HttpStatus.BAD_REQUEST){//The person exists but password is wrong.
            model.addAttribute("wrong_password", "Sorry, your password was incorrect. Please double-check your password.");
            return "index";
        }else if (statusCode == HttpStatus.NOT_FOUND) {//The person doesn't exist so that email is wrong.
            model.addAttribute("wrong_email", "Sorry, your email was not found. Please double-check your email.");
            return "index";
        }else {
            return "index";
        }
    }





}
