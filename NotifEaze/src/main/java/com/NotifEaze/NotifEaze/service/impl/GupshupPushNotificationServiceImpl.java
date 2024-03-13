package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.PushNotificationService;

@Service
public class GupshupPushNotificationServiceImpl implements PushNotificationService {

	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {

		String mockedResponse = GupshupMock.PN_MOCKED_RESPONSES.get(fcmToken);
		BasePushNotificationResponse notificationResponse = parseNotificationResponse(mockedResponse);
		return notificationResponse;
	}

	private BasePushNotificationResponse parseNotificationResponse(String mockedResponse) {
		return new BasePushNotificationResponse(true, "Notification sent successfully");
	}

}
