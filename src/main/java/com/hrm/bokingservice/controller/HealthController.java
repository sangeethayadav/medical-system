package com.hrm.bokingservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/v1/")
public class HealthController {

	@RequestMapping(value = "health-check", method = RequestMethod.GET)
	public String healthCheck() {
		return "Every  thing is working fine";
	}

}
