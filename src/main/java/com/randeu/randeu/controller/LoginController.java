package com.randeu.randeu.controller;
import com.randeu.randeu.model.Person;
import com.randeu.randeu.service.LoginService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }

    @PostMapping("/signIn")
    public String userSignIn(@ModelAttribute Person person){
        System.out.println(person.getEmail()+" "+person.getPassword());
        return "index";
    }


}
