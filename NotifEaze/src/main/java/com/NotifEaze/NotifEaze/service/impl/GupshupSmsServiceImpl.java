package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.SmsService;

@Primary
@Service
public class GupshupSmsServiceImpl implements SmsService {

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		String mockedResponse = GupshupMock.SMS_MOCKED_RESPONSES.get("MessageId1");
		BaseSmsResponse smsResponse = parseSmsResponse(mockedResponse);
		return smsResponse;
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		String mockedResponse = GupshupMock.SMS_DELIVERY_STATUS_MOCKED_RESPONSES.get(messageId);
		SmsDeliveryStatus deliveryStatus = parseDeliveryStatus(mockedResponse);
		return deliveryStatus;
	}

	// Helper method to parse mocked SMS response
	private BaseSmsResponse parseSmsResponse(String mockedResponse) {
		return new BaseSmsResponse(true, "Message sent successfully");
	}

	private SmsDeliveryStatus parseDeliveryStatus(String mockedResponse) {
		return new SmsDeliveryStatus(true, "Message delivered successfully");
	}

}
