package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.focalpoint.Focalist.models.Task;
import com.focalpoint.Focalist.models.TaskRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class TaskController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/api/task")
    public RedirectView addTask(String title, String note, String time, String offset, Principal p) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        DateTime taskTime = DateTime.parse(time);
        int offsetHours = Integer.parseInt(offset);
        taskTime = taskTime.plusHours(offsetHours);
        Date taskUtcTime = taskTime.toDate();
        Task newTask = new Task(title, note, taskUtcTime, offsetHours, currentUser);
        taskRepository.save(newTask);
        return new RedirectView("/userAccount");
    }
}
