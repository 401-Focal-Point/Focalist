package com.focalpoint.Focalist;

import com.focalpoint.Focalist.config.TwilioConfiguration;
import com.focalpoint.Focalist.models.Service;
import com.focalpoint.Focalist.models.SmsRequest;
import com.focalpoint.Focalist.models.TwilioSmsSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
public class FocalistApplication {

	public static void main(String[] args) {
        SpringApplication.run(FocalistApplication.class, args);
    }

}
