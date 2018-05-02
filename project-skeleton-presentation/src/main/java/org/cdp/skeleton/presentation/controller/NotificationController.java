package org.cdp.skeleton.presentation.controller;

import org.cdp.skeleton.facade.converter.NotificationConverter;
import org.cdp.skeleton.facade.model.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationConverter notificationConverter;

    @Value("${my.app.property}")
    private String myAppProperty; //just to test that property is being loaded from application.properties file

    @RequestMapping("/load-notification")
    public ResponseEntity<NotificationDTO> loadNotification() {
        LOG.info("Inside load-notification method");
        return ResponseEntity.ok().body(notificationConverter.convert());
    }

    @RequestMapping("/show-property")
    public ResponseEntity<String> showProperty() {
        return ResponseEntity.ok().body(myAppProperty);
    }
}
