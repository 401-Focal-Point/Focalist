package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.focalpoint.Focalist.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // Receives data from form that gets new user data
    @PostMapping("/signup")
    public RedirectView addUser(String firstName,
                                String lastName,
                                String phoneNumber,
                                String password,
                                String email) {

        // create newUser and salt & hash password
        ApplicationUser newUser = new ApplicationUser(firstName,
                                                    lastName,
                                                    "+1" + phoneNumber,
                                                    passwordEncoder.encode(password),
                                                    email);

        if (applicationUserRepository.findByUsername(email) == null) {
            // save newUser to database focalist
            applicationUserRepository.save(newUser);

            // allow autologin after signing up for an account
            Authentication authentication = new UsernamePasswordAuthenticationToken(newUser,
                    null,
                    new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return new RedirectView("/userAccount");
        } else {
            // add param to then be shown in the front end
            return new RedirectView("/?usernametaken");
        }
    }

    // Go to userAccount page
    @GetMapping("/userAccount")
    public String getUserAccount(Principal p, Model m) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("name", currentUser.getFirstName());
        m.addAttribute("user", currentUser);

        // sort messages by time in displayed messages
        List<Task> userTasks = currentUser.getTasks();
        userTasks.sort(Comparator.comparing(Task::getUtcTime));

        List<Task> uncompletedTasks = new LinkedList<>();
        List<Task> completedTasks = new LinkedList<>();

        // split the sorted tasks into two list, one for uncompleted and one for completed
        for (Task task: userTasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            } else {
                uncompletedTasks.add(task);
            }
        }
        m.addAttribute("uncompletedTasks", uncompletedTasks);
        m.addAttribute("completedTasks", completedTasks);
        return "userAccount";
    }
}
