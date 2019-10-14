package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.ApplicationUser;
import com.focalpoint.Focalist.models.ApplicationUserRepository;
import com.focalpoint.Focalist.models.Task;
import com.focalpoint.Focalist.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.OffsetDateTime;

@Controller
public class TaskController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    TaskRepository taskRepository;

    // TODO: figure out how to store date and timezone
    @PostMapping("/api/task")
    public void addTask(String title, String note, String time, String offset, String username) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(username);
        OffsetDateTime taskTime = OffsetDateTime.parse(time);
        Integer offsetMinutes = Integer.parseInt(offset);
        if (offsetMinutes > 0) {
            taskTime.plusMinutes(offsetMinutes);
        } else if (offsetMinutes < 0) {
            taskTime.minusMinutes(offsetMinutes);
        }
        Task newTask = new Task(title, note, taskTime, currentUser);
        taskRepository.save(newTask);
    }
}
