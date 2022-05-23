package com.abidevel.notification.notificationgateway.service;

public interface EmailService {
    boolean sendEmail(String emailTo, String body, String subject);
}
