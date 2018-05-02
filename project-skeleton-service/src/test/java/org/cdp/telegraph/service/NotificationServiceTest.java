package org.cdp.skeleton.service;

import org.cdp.skeleton.persistence.dao.NotificationDAO;
import org.cdp.skeleton.persistence.model.Notification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

    @Mock
    private NotificationDAO notificationDAOMock;

    @InjectMocks
    private NotificationService notificationService = new NotificationService();


    @Test
    public void testCheckCorrectGetterValuesWhenNotificationReturned() {
        // Given
        final String subject = "subjectTest";
        final String body = "bodyTest";
        final Notification notification = new Notification();
        notification.setSubject(subject);
        notification.setBody(body);

        Mockito.when(notificationDAOMock.getNotification()).thenReturn(notification);

        // When
        final Notification notificationActual = notificationService.getNotification();

        // Then
        Assert.assertEquals(subject, notificationActual.getSubject());
        Assert.assertEquals(body, notificationActual.getBody());
    }
}
