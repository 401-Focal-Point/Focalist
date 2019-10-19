package com.focalpoint.Focalist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Configure twilio according to my own account
// This will holds private information regarding account sid, authorization token and trial number
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfiguration {
    private static String accountSid;
    private static String authToken;
    private static String trialNumber;

    public TwilioConfiguration() {
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}
