package com.randeu.randeu.controller;
import com.randeu.randeu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }
}
