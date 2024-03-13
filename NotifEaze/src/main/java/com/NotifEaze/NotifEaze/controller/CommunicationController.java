package com.NotifEaze.NotifEaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.SmsService;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {

	@Autowired
	private SmsService smsService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/api/communication/send-sms")
	public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody SmsRequest smsRequest) {
		BaseSmsResponse response = smsService.sendSms(smsRequest.getPhoneNumber(), smsRequest.getMessage());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/api/communication/send-email")
	public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
		BaseEmailResponse response = emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(),
				emailRequest.getBody());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/send-notification")
	public ResponseEntity<BasePushNotificationResponse> sendNotification() {
		return ResponseEntity.ok().build();
	}
}
