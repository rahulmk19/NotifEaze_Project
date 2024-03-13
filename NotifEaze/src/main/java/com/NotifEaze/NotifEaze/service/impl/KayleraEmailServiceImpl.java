package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.EmailService;

@Service
public class KayleraEmailServiceImpl implements EmailService {

	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		String mockedResponse = KayleraMock.EMAIL_MOCKED_RESPONSES.get("Email1");
		BaseEmailResponse emailResponse = parseEmailResponse(mockedResponse);
		return emailResponse;
	}

	private BaseEmailResponse parseEmailResponse(String mockedResponse) {
		return new BaseEmailResponse(true, "Email sent successfully");
	}

}
