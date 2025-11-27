package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.EmailCall;

@RestController
public class StudentEmail {
	@Autowired
	private EmailCall emailCall;

	public StudentEmail(EmailCall emailCall) {
		this.emailCall = emailCall;
	}
	
	@PostMapping("/send-mail")
	public String studentEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
		return emailCall.sendEmail(to, subject, body);
	}
}
