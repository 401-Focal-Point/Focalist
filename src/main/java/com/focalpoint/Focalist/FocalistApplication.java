package com.focalpoint.Focalist;

import com.focalpoint.Focalist.config.TwilioConfiguration;
import com.focalpoint.Focalist.models.Service;
import com.focalpoint.Focalist.models.SmsRequest;
import com.focalpoint.Focalist.models.TwilioSmsSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class FocalistApplication {

	public static final String ACCOUNT_SID = "AC029ed32cac2529c01d645ee5abfd3734";
	public static final String AUTH_TOKEN = "e32e258e0342d30a4e616ea01dcf7741";

	public static void main(String[] args) {
//		SpringApplication.run(FocalistApplication.class, args);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        /* First number is the TO number, must be a verified number in Twilio
         * Second number is our Twilio number that CANNOT be changed
         */
        Message message = Message.creator(new PhoneNumber("+14253193557"),
                new PhoneNumber("+12055395676"),
                "This is a test message sent from Twilio.").create();

        System.out.println(message.getSid());

        SpringApplication.run(FocalistApplication.class, args);
    }

}
