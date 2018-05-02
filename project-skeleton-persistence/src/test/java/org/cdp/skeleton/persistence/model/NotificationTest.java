package org.cdp.skeleton.persistence.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationTest {

    @Test
    public void testCheckCorrectGetterValuesWhenNotificationModelCreated() {
        // When
        final String subject = "SubjectTest";
        final Notification notification = new Notification();
        notification.setSubject(subject);

        // Then
        Assert.assertEquals(subject, notification.getSubject());
    }
}
