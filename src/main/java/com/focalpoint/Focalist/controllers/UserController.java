package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.twilio.rest.api.v2010.account.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // TODO: change return type back to RedirectView
    @PostMapping("/user")
    public void addUser(String firstName, String lastName, String phoneNumber, String password, String email) {
        ApplicationUser newUser = new ApplicationUser(firstName,
                                                    lastName,
                                                    phoneNumber,
                                                    passwordEncoder.encode(password),
                                                    email);
        applicationUserRepository.save(newUser);
        // TODO: change the redirect view to where the main page is
//        return new RedirectView("");
    }
}
