package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.twilio.rest.api.v2010.account.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // Go to signup page
    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    // Receives data from form that gets new user data
    @PostMapping("/signup")
    public RedirectView addUser(String firstName, String lastName, String phoneNumber, String password, String email) {

        // create newUser and salt & hash password
        ApplicationUser newUser = new ApplicationUser(firstName,
                                                    lastName,
                                                    "+1" + phoneNumber,
                                                    passwordEncoder.encode(password),
                                                    email);

        // save newUser to database focalist
        applicationUserRepository.save(newUser);

        // allow autologin after signing up for an account
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser,
                null,
                new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // send user back to homepage after setting up account
        return new RedirectView("/");
    }

    // Go to login page
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


}
