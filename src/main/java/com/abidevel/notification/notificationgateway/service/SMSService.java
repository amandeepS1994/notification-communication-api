package com.abidevel.notification.notificationgateway.service;

public interface SMSService {
    boolean sendNotification (String number, String body);
    
}
