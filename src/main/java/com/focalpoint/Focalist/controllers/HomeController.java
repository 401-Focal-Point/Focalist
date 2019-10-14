package com.focalpoint.Focalist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Principal p, Model m) {
//        if (p != null) {
//            m.addAttribute("email", p.getName());
//        }
        return "home";
    }
}
