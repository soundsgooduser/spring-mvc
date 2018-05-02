package org.cdp.skeleton.facade.converter;

import org.apache.commons.lang3.StringUtils;
import org.cdp.skeleton.facade.annotation.Facade;
import org.cdp.skeleton.facade.model.NotificationDTO;
import org.cdp.skeleton.persistence.model.Notification;
import org.cdp.skeleton.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Facade
public class NotificationConverter {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationConverter.class);

    @Autowired
    private NotificationService notificationService;

    public final NotificationDTO convert() {
        LOG.info("Convert Notification object to NotificationDTO object");
        final NotificationDTO notificationDTO = new NotificationDTO();
        final Notification notification = notificationService.getNotification();
        notificationDTO.setNotificationSubjAndBody(StringUtils.join(notification.getSubject(),
                ", ", notification.getBody()));
        return notificationDTO;
    }
}
