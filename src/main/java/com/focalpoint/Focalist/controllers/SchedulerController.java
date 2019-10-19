package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

// Controller for receiving ping from Heroku Scheduler and checks if messages need to be sent or not
@Controller
public class SchedulerController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    SmsService smsService;

    @GetMapping("/api/schedule")
    public void scheduleMessage () {
        // get all of the tasks in a list that are not completed ordered by utc_time in ascending order
        List<Task> tasks = taskRepository.findAllNotCompleteOrderByUTC();
        // Get the current time for servers and also time that is 10 minutes from now
        Date currentServerTime = DateTime.now().toDate();
        Date currentServerTimePlusClockProcessInterval = DateTime.now().plusMinutes(10).toDate();   // need to change the 10 minutes to be an environmental variable or part of a configuration class for Heroku

        // Go through the list of uncompleted tasks from earliest to latest and check if the tasks need to be sent within the next 10 minutes or not
        // If so sent the task as a message
        // If not, break out of the loop since the rest of the tasks won't be within the next 10 minutes as well
        for (Task task: tasks) {
            Date taskTime = task.getUtcTime();
            if ((taskTime.after(currentServerTime) && taskTime.before(currentServerTimePlusClockProcessInterval)) || taskTime.before(currentServerTime)) {
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
