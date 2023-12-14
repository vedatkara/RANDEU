package com.randeu.randeu.controller;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }

    @PostMapping("/signIn")
    public ResponseEntity<Person> userSignIn(@ModelAttribute Person person){
        return loginService.authenticate(person.getEmail(), person.getPassword());
    }


}
