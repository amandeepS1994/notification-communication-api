package com.abidevel.notification.notificationgateway.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@PropertySource("classpath:gmail.properties")
@Configuration
public class MailConfiguration {

    private final String emailFrom;

    public MailConfiguration (@Value("${email.from}") String emailFrom) {
        this.emailFrom = emailFrom;
    }

    
}
