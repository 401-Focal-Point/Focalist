package com.focalpoint.Focalist.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        // establish connection to Twilio API for our account
        Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken());
    }
}
