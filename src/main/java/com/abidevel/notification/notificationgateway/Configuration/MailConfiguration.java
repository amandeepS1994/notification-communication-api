package com.abidevel.notification.notificationgateway.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@PropertySource("classpath:gmail.properties")
@Configuration
public class MailConfiguration {

    // private final String emailFrom;
    // private final String host;
    // private final int portNumber;
    // private final String protocol;
    // private final boolean testConnection;
    // private final boolean useAuth;
    // private final String username;
    // private final String password;

    private final String emailFrom;

    public MailConfiguration (@Value("${email.from}") String emailFrom) {
        this.emailFrom = emailFrom;
    }

    
}
