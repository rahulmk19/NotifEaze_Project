package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.SmsService;

@Service
public class KayleraSmsServiceImpl implements SmsService {

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		String mockedResponse = KayleraMock.SMS_MOCKED_RESPONSES.get("123456");
		BaseSmsResponse smsResponse = parseSmsResponse(mockedResponse);
		return smsResponse;
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		String mockedResponse = KayleraMock.SMS_MOCKED_RESPONSES.get(messageId);
		SmsDeliveryStatus deliveryStatus = parseDeliveryStatus(mockedResponse);
		return deliveryStatus;
	}

	private BaseSmsResponse parseSmsResponse(String mockedResponse) {
		return new BaseSmsResponse(true, "Message sent successfully");
	}

	private SmsDeliveryStatus parseDeliveryStatus(String mockedResponse) {
		return new SmsDeliveryStatus(true, "Message delivered successfully");
	}

}
