package com.abidevel.notification.notificationgateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("health/")
    public String retrieveSystemHealth () {
        return "UP";
    }
    
}
