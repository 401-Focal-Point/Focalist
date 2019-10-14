package com.focalpoint.Focalist.controllers;

import com.focalpoint.Focalist.models.Service;
import com.focalpoint.Focalist.models.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class SmsController {

    private final Service service;

    @Autowired
    public SmsController(Service service) {
        this.service = service;
    }

    @PostMapping("api/sms")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
}
