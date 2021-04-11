package com.hrm.bokingservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.bokingservice.dto.FeedbackDto;
import com.hrm.bokingservice.entity.DepartmentEntity;
import com.hrm.bokingservice.entity.FeedbackEntity;
import com.hrm.bokingservice.exception.CustomException;
import com.hrm.bokingservice.repository.FeedbackRepository;
import com.hrm.bokingservice.service.FeedbackService;
import com.hrm.bokingservice.util.ApplicationExceptionMsgUtil;
import com.hrm.bokingservice.util.ApplicationMsgUtil;
import com.hrm.bokingservice.vo.DepartmentVo;
import com.hrm.bokingservice.vo.FeedbackVo;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	public FeedbackRepository feedbackRepository;

	@Override
	public String saveFeedback(FeedbackVo feedbackVo) throws Exception {

		FeedbackEntity feedbackEntity = new FeedbackEntity();
		BeanUtils.copyProperties(feedbackVo, feedbackEntity);
		feedbackEntity = feedbackRepository.save(feedbackEntity);		
		return feedbackEntity!=null?ApplicationMsgUtil.FEEDBACK_SAVE_MSG:null;
		

	}

	@Override
	public List<FeedbackDto> findAllFeedback() throws Exception {

		List<FeedbackEntity> feedbackEntityList = feedbackRepository.findAll();

		return null;
	}

	@Override
	public FeedbackDto getByfeedbackId(Long feedbackId) throws Exception {
		
		
		
		return null;
	}

	@Override
	public String deleteQuery(int departmentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(FeedbackVo feedbackVo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * private Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	 * 
	 * @Autowired public FeedbackRepository feedbackRepository;
	 * 
	 * @Override public String saveDepartment(FeedbackVo feedbackVo) throws
	 * Exception { FeedbackEntity feedbackEntity = null; Optional<FeedbackEntity>
	 * entity = feedbackRepository .findByFeedbackId(feedbackVo.getFeedbackId()); if
	 * (entity.isPresent()) { throw new
	 * CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_DUPLICATE_MSG_CODE,
	 * ApplicationExceptionMsgUtil.DEPARTMENT_DUPLICATE_EX_MSG); } else {
	 * feedbackEntity = new FeedbackEntity();
	 * feedbackEntity.setFeedbackId(feedbackVo.getFeedbackId());
	 * feedbackRepository.save(feedbackEntity); } return
	 * ApplicationMsgUtil.DEPARTMENT_SAVE_MSG; }
	 * 
	 * 
	 */}
