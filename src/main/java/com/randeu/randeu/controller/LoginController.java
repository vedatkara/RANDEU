package com.randeu.randeu.controller;

import com.randeu.randeu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("randeu_login_page.html")
public class LoginController {

    @Autowired
    LoginService loginService;
}
