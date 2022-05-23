package com.abidevel.notification.notificationgateway.Controller;

import java.util.Objects;

import com.abidevel.notification.notificationgateway.Model.Enumeration.NotificationType;
import com.abidevel.notification.notificationgateway.Model.Request.NotificationRequest;
import com.abidevel.notification.notificationgateway.Model.Response.ApiResponse;
import com.abidevel.notification.notificationgateway.service.EmailService;
import com.abidevel.notification.notificationgateway.service.SMSService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "notification/")
public class NotificationController {

    private final SMSService smsService;
    private final EmailService emailService;

    public NotificationController (SMSService snsService, EmailService emailService) {
        this.smsService = snsService;
        this.emailService = emailService;
    }
    
    @PostMapping(path = "")
    public ResponseEntity<ApiResponse<Object>> sendNotification (@RequestBody NotificationRequest notificationRequest) {
        if (Objects.nonNull(notificationRequest)) {
            if (notificationRequest.getNotificationMode().equals(NotificationType.EMAIL)) {
                return emailService.sendEmail(notificationRequest.getEmailAddress(), notificationRequest.getNotificationContent(), notificationRequest.getEmailSubject()) ? new ResponseEntity<>(ApiResponse.builder().isSuccessful(true).message("Email Notification Sent.").build(), HttpStatus.ACCEPTED) : new ResponseEntity<>(ApiResponse.builder().isSuccessful(false).message("Failed to Send Email Notification.").build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (notificationRequest.getNotificationMode().equals(NotificationType.SMS)) {
                return  smsService.sendNotification(notificationRequest.getPhoneNumber(), notificationRequest.getNotificationContent()) ? new ResponseEntity<>(ApiResponse.builder().isSuccessful(true).message("SMS Notification Sent.").build(), HttpStatus.ACCEPTED) : new ResponseEntity<>(ApiResponse.builder().isSuccessful(false).message("Failed to Send SMS Notification.").build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        }
        return new ResponseEntity<>(ApiResponse.builder().isSuccessful(false).message("Implementation coming soon.").build(), HttpStatus.NOT_IMPLEMENTED);
    }


}
