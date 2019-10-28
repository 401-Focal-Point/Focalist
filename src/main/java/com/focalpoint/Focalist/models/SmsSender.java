package com.focalpoint.Focalist.models;

// Defines what sms provider should able to do which is send sms by accepting a request
// This feels overly-generified; for this app, it's going too far.
// It makes me nervous about whether you understood what the Twilio video tutorial was showing you,
// and actively choosing which pieces to include/not include in your application.
public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
