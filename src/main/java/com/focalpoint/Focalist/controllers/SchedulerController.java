package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public void scheduleMessage () {
//        make an ordered list or all tasks
        System.out.println("Got in");
        List<Task> tasks = taskRepository.findAllNotCompleteOrderByUTC();
        Date currentServerTime = DateTime.now().toDate();
        System.out.println(currentServerTime);
        Date currentServerTimePlusClockProcessInterval = DateTime.now().plusMinutes(10).toDate();

        for (Task task: tasks) {
            System.out.println("Got in task");
            Date taskTime = task.getUtcTime();
            System.out.println(taskTime);
            if ((taskTime.after(currentServerTime) && taskTime.before(currentServerTimePlusClockProcessInterval)) || taskTime.before(currentServerTime)) {
                System.out.println("Got in sending messages");
                System.out.println(task.toString());
                SmsRequest newMessage = new SmsRequest(task.getApplicationUser().getPhoneNumber(), task.toString());
                smsService.sendSms(newMessage);
                task.setCompleted(true);
                taskRepository.save(task);
            } else {
                break;
            }
        }
    }
}
