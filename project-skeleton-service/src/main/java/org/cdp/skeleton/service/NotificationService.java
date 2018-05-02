package org.cdp.skeleton.service;

import org.cdp.skeleton.persistence.dao.NotificationDAO;
import org.cdp.skeleton.persistence.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class NotificationService {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    @Inject
    private NotificationDAO notificationDAO;

    public Notification getNotification() {
        LOG.info("Inside getNotification method");
        return notificationDAO.getNotification();
    }
}
