package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {
    @RequestMapping("/signup")
    public String getLoginPage() {
        return "signup";
    }
}