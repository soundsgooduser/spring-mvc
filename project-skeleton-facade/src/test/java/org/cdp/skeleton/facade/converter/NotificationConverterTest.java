package org.cdp.skeleton.facade.converter;

import org.cdp.skeleton.facade.model.NotificationDTO;
import org.cdp.skeleton.persistence.model.Notification;
import org.cdp.skeleton.service.NotificationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationConverterTest {

    @Mock
    private NotificationService notificationServiceMock;

    @InjectMocks
    private NotificationConverter notificationConverter = new NotificationConverter();

    @Test
    public void testConvertNotificationModelToNotificationDTO() {
        // Given
        final String expectedResult = "subjectTest, bodyTest";
        final String subject = "subjectTest";
        final String body = "bodyTest";
        final Notification notification = new Notification();
        notification.setSubject(subject);
        notification.setBody(body);

        Mockito.when(notificationServiceMock.getNotification()).thenReturn(notification);

        // When
        final NotificationDTO notificationDTO = notificationConverter.convert();

        // Then
        Assert.assertEquals(expectedResult, notificationDTO.getNotificationSubjAndBody());
    }
}
