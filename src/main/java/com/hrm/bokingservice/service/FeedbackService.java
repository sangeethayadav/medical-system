package com.hrm.bokingservice.service;

import java.util.List;

import com.hrm.bokingservice.dto.FeedbackDto;
import com.hrm.bokingservice.vo.FeedbackVo;

public interface FeedbackService {
    
	public String saveFeedback(FeedbackVo feedbackVo) throws Exception;
	
	public List<FeedbackDto> findAllFeedback() throws Exception;
	
	public FeedbackDto  getByfeedbackId(Long feedbackId) throws Exception;
	
	public String deleteQuery(int departmentId)throws Exception;
	
	public String update(FeedbackVo  feedbackVo) throws Exception;
	
	

}
