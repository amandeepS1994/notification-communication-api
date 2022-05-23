package com.abidevel.notification.notificationgateway.Configuration;

import com.twilio.Twilio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:twilio.properties")
public class TwilioConfiguration {
    private final String accountId;
    private final String authToken;
    private final String numberFrom;

    public TwilioConfiguration (@Value("${twilio.accountsid}") String accountId, @Value("${twilio.authtoken}") String authToken,  @Value("${twilio.numberFrom}") String numberFrom) {
        this.accountId = accountId;
        this.authToken = authToken;
        this.numberFrom = numberFrom;
        Twilio.init(this.accountId, this.authToken);
    }


}
