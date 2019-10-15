package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.*;

@Controller
public class   SchedulerController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    SmsService smsService;

    @GetMapping("/api/schedule")
    public void scheduleMessage (Principal p) {
        System.out.println("got in");
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        List<Task> tasks = taskRepository.findByApplicationUserIdOrderByUtcTime(currentUser.getId());
        Date currentServerTime = DateTime.now().toDate();
        Date currentServerTimePlusClockProcessInterval = DateTime.now().plusMinutes(10).toDate();
        for (Task task: tasks) {
            Date taskTime = task.getUtcTime();
            if (taskTime.after(currentServerTime) && taskTime.before(currentServerTimePlusClockProcessInterval)) {
                System.out.println(task.toString());
                SmsRequest newMessage = new SmsRequest(currentUser.getPhoneNumber(), task.toString());
                smsService.sendSms(newMessage);
            }
        }
    }
}
