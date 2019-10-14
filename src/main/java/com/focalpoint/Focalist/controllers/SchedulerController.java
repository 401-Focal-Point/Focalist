package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.Task;
import com.focalpoint.Focalist.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Controller
public class SchedulerController {

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/api/schedule")
    public void scheduleMessage () {
//        List<Task> tasks = taskRepository.findAllOrderByTime();
//        List<Task> taskToBeSent = new ArrayList<>();
//        ZoneOffset zoneOffSet= ZoneOffset.of("Z");
//        OffsetDateTime currentServerTime = OffsetDateTime.now();
//        OffsetDateTime currentServerTimePlusClockInterval =
//        for (int i = 0; i < tasks.size(); i++) {
////            if (tasks.get(i).getTime().isAfter(currentServerTime)) {
////
////            }
////        }
    }
}
