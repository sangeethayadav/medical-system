package com.hrm.bokingservice.service;

import java.util.List;

import com.hrm.bokingservice.dto.DepartmentDto;
import com.hrm.bokingservice.vo.DepartmentVo;

public interface DepartmentService {

	public String saveDepartment(DepartmentVo departmentVo) throws Exception;

	public List<DepartmentDto> findAll() throws Exception;
	
	public DepartmentDto  findById(int departmentId) throws Exception;
	
	public String update(DepartmentVo  departmentVo) throws Exception;
	
	public String delete(int departmentId)throws Exception;
	
	public String setStatus(int departmentId,int status)throws Exception;
	

}
