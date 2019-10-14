package com.focalpoint.Focalist.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    @Autowired
    TwilioConfiguration twilioConfiguration;

    public TwilioInitializer() {
        // establish connection to Twilio API for our account
        Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken());
    }
}
