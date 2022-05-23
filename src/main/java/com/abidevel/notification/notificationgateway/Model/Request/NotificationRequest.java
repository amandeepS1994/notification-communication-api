package com.abidevel.notification.notificationgateway.Model.Request;

import com.abidevel.notification.notificationgateway.Model.Enumeration.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NotificationRequest {
    private long customerId;
    private NotificationType notificationMode;
    private String notificationContent;
    private String emailAddress;
    private String emailSubject;
    private String phoneNumber;   
    
    
}
