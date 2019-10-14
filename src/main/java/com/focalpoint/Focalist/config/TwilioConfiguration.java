//package com.focalpoint.Focalist.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//// Configure twilio according to my own account
//// This will holds private information regarding account sid, authorization token and trial number
//@Configuration
//@ConfigurationProperties(prefix = "twilio")
//public class TwilioConfiguration {
////    @Value("${twilio.account.sid}")
//    private String accountSid;
////    @Value("${twilio.auth.token}")
//    private String authToken;
////    @Value("${twilio.trial.number}")
//    private String trialNumber;
//
//    public TwilioConfiguration() {}
//
//    public String getAccountSid() {
//        return accountSid;
//    }
//
//    public void setAccountSid(String accountSid) {
//        this.accountSid = accountSid;
//    }
//
//    public String getAuthToken() {
//        return authToken;
//    }
//
//    public void setAuthToken(String authToken) {
//        this.authToken = authToken;
//    }
//
//    public String getTrialNumber() {
//        return trialNumber;
//    }
//
//    public void setTrialNumber(String trialNumber) {
//        this.trialNumber = trialNumber;
//    }
//}
