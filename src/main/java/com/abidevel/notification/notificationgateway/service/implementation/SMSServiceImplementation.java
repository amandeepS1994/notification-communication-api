package com.abidevel.notification.notificationgateway.service.implementation;

import java.util.Objects;

import com.abidevel.notification.notificationgateway.Configuration.TwilioConfiguration;
import com.abidevel.notification.notificationgateway.service.SMSService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SMSServiceImplementation implements SMSService{

    private final TwilioConfiguration twilioConfig;

    public SMSServiceImplementation (TwilioConfiguration twilioConfiguration) {
        this.twilioConfig = twilioConfiguration;
    }

    @Override
    public boolean sendNotification(String number, String body) {
        Message message = Message.creator(new PhoneNumber(number), new PhoneNumber(twilioConfig.getNumberFrom()), body).create();
        return Objects.nonNull(message.getAccountSid());
    }
    
}
