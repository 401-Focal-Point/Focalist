package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.*;

@Controller
public class SchedulerController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    SmsService smsService;

    @GetMapping("/api/schedule")
    public String scheduleMessage (Model m) {
        System.out.println("got in");
//        make an ordered list or all tasks
        List<Task> tasks = taskRepository.findAllOrderByUtcTime();
        Date currentServerTime = DateTime.now().toDate();
        m.addAttribute("currentServerTime", currentServerTime);
        Date currentServerTimePlusClockProcessInterval = DateTime.now().plusMinutes(10).toDate();
        m.addAttribute("currentServerTimePlus10Minutes", currentServerTimePlusClockProcessInterval);
        m.addAttribute("tasks", tasks);
        for (Task task: tasks) {
            Date taskTime = task.getUtcTime();
            if (taskTime.after(currentServerTime) && taskTime.before(currentServerTimePlusClockProcessInterval)) {
                System.out.println(task.toString());
                SmsRequest newMessage = new SmsRequest(task.getApplicationUser().getPhoneNumber(), task.toString());
                smsService.sendSms(newMessage);
            }
        }
        return "test";
    }
}
