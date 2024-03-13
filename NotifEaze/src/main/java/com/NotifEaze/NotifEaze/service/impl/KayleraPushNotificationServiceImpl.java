package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.service.PushNotificationService;

@Service
public class KayleraPushNotificationServiceImpl implements PushNotificationService {

	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
		return new BasePushNotificationResponse(true, "Notification sent successfully");
	}
}
