package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.focalpoint.Focalist.models.Task;
import com.focalpoint.Focalist.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    TaskRepository taskRepository;

    // TODO: figure out how to store date and timezone
    @PostMapping("api/task")
    public void addTask(String title, String note, String date, String timeZone, Principal p) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        Task newTask = new Task(title, note, date, timeZone, currentUser);
        taskRepository.save(newTask);
    }
}
