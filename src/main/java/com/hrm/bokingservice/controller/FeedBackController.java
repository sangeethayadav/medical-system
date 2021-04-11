package com.hrm.bokingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.bokingservice.service.FeedbackService;
import com.hrm.bokingservice.vo.FeedbackVo;

@RestController
@RequestMapping("/v1/feedback")
public class FeedBackController {

	@Autowired
	FeedbackService feedbackService;

	@PostMapping("/addFeedBack")
	public String getFeedbackVo(@RequestBody FeedbackVo feedbackVo) {

		try {

			return feedbackService.saveFeedback(feedbackVo);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping("/getbyId")
	public FeedbackVo getFeedbackById(@RequestParam Long feedbackId) {

		try {

			FeedbackVo feedbackVo=feedbackService.getByfeedbackId(feedbackId);
			
			return 

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
