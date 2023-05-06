package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import java.util.ArrayList;

@Controller
public class LoginController {

    //List<User> submittedCreds = new ArrayList<>();
    @RequestMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/applogin")
    public String getUser(Model model) {
    //    User user = new User(username:"pa", password:"sa")
        model.addAttribute("user", new User());
        return "login";

    }

    @PostMapping("/handleSubmit")
    public String submitUser(User user) {
        System.out.println(user);
        //submittedCreds.add(user);
        return "abc";
    }

}

