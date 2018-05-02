package org.cdp.skeleton.persistence.dao;

import org.cdp.skeleton.persistence.model.Notification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationDAOTest {

    @Test
    public void testCheckCorrectGetterValuesWhenNotificationReturned() {
        // Given
        final String notificationSubjectTest = "notificationSubjectTest";
        final String notificationBodyTest = "notificationBodyTest";
        final NotificationDAO notificationDAO = new NotificationDAO();
        notificationDAO.setSubject(notificationSubjectTest);

        // When
        final Notification notification = notificationDAO.getNotification();

        // Then
        Assert.assertEquals(notificationSubjectTest, notification.getSubject());
        Assert.assertEquals(notificationBodyTest, notification.getBody());
    }
}

