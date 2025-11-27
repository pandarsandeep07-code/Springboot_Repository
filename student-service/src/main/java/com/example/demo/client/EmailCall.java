package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo", url = "http://localhost:8080")
public interface EmailCall {
	
	@GetMapping("/send-email")
	public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body);
}
