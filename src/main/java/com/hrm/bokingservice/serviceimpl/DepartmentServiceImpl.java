package com.hrm.bokingservice.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.bokingservice.dto.DepartmentDto;
import com.hrm.bokingservice.entity.DepartmentEntity;
import com.hrm.bokingservice.exception.CustomException;
import com.hrm.bokingservice.repository.DepartmentRepository;
import com.hrm.bokingservice.service.DepartmentService;
import com.hrm.bokingservice.util.ApplicationExceptionMsgUtil;
import com.hrm.bokingservice.util.ApplicationMsgUtil;
import com.hrm.bokingservice.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public String saveDepartment(DepartmentVo departmentVo) throws Exception {
		DepartmentEntity departmentEntity = null;
		
		Optional<DepartmentEntity> entity = departmentRepository
				.findByDepartmentName(departmentVo.getDepartmentName().trim());
		
		if (entity.isPresent()) {
			throw new CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_DUPLICATE_MSG_CODE,
					ApplicationExceptionMsgUtil.DEPARTMENT_DUPLICATE_EX_MSG);
		} else {
			departmentEntity = new DepartmentEntity();
			departmentEntity.setDepartmentName(departmentVo.getDepartmentName().trim());
			departmentRepository.save(departmentEntity);
		}
		return ApplicationMsgUtil.DEPARTMENT_SAVE_MSG;
	}

	@Override
	public List<DepartmentDto> findAll() throws Exception {
		List<DepartmentEntity> list = null;
		List<DepartmentDto> responseList = null;
		try {
			list = departmentRepository.findByFlag(0);
			if (Objects.nonNull(list)) {
				responseList = new ArrayList<DepartmentDto>();
				for (DepartmentEntity entity : list) {
					DepartmentDto dept = new DepartmentDto();
					BeanUtils.copyProperties(entity, dept);
					responseList.add(dept);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return responseList;
	}

	@Override
	public DepartmentDto findById(int departmentId) throws Exception {
		DepartmentDto departmentDto = null;
		Optional<DepartmentEntity> entity = departmentRepository.findById(departmentId);
		logger.info("department Id ==>" + entity.get().getDepartmentId());
		if (entity.isPresent()) {
			departmentDto = new DepartmentDto();
			BeanUtils.copyProperties(entity.get(), departmentDto);
		} else {
			throw new CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_CODE,
					ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_EX_MSG);
		}
		return departmentDto;
	}

	@Override
	public String update(DepartmentVo departmentVo) throws Exception {
		DepartmentEntity departmentEntity = null;
		Optional<DepartmentEntity> entity = departmentRepository.findById(departmentVo.getDeparmentId());
		logger.info("department Id ==>" + entity.get().getDepartmentId());
		if (entity.isPresent()) {
			departmentEntity = entity.get();
			departmentEntity.setDepartmentId(departmentVo.getDeparmentId());
			departmentEntity.setDepartmentName(departmentVo.getDepartmentName());
			departmentRepository.save(departmentEntity);

		} else {
			throw new CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_CODE,
					ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_EX_MSG);
		}

		return ApplicationMsgUtil.DEPARTMENT_UPDATE_MSG;
	}

	@Override
	public String delete(int departmentId) throws Exception {
		DepartmentEntity departmentEntity = null;
		Optional<DepartmentEntity> entity = departmentRepository.findById(departmentId);
		if (entity.isPresent()) {
			departmentEntity = entity.get();
			departmentEntity.setFlag(1);
			departmentRepository.save(departmentEntity);

		} else {
			throw new CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_CODE,
					ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_EX_MSG);
		}
		return ApplicationMsgUtil.DEPARTMENT_DELETE_MSG;
	}

	@Override
	public String setStatus(int departmentId, int status) throws Exception {
		DepartmentEntity departmentEntity = null;
		String msg = "";
		Optional<DepartmentEntity> entity = departmentRepository.findById(departmentId);
		if (entity.isPresent()) {
			departmentEntity = entity.get();
			departmentEntity.setStatus(status);
			departmentRepository.save(departmentEntity);
			if (status == 1) {
				msg = ApplicationMsgUtil.DEPARTMENT_ACTIVE_STATUS_MSG;
			} else if (status == 0) {
				msg = ApplicationMsgUtil.DEPARTMENT_IN_ACTIVE_STATUS_MSG;
			}
		} else {
			throw new CustomException(ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_CODE,
					ApplicationExceptionMsgUtil.DEPARTMENT_NOT_FOUND_EX_MSG);
		}

		return msg;

	}

}
