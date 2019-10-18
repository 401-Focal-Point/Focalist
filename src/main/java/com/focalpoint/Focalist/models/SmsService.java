package com.focalpoint.Focalist.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// Defines a general sms service that is independent of the sms provider
@org.springframework.stereotype.Service
public class SmsService {
    private final SmsSender smsSender;

    // Construct smsService specifically using the service that is named twilio which is defined int TwilioSmsSender class
    @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
