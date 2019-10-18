package com.focalpoint.Focalist.models;

// Defines what sms provider should able to do which is send sms by accepting a request
public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
