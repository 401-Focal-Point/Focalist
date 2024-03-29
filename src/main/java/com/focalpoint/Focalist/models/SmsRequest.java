package com.focalpoint.Focalist.models;

import com.fasterxml.jackson.annotation.JsonProperty;

// This class defines what our text message request object will look like
// This object will be passed into smsService to send to Twilio
public class SmsRequest {

    private final String phoneNumber;
    private final String message;

    public SmsRequest(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
