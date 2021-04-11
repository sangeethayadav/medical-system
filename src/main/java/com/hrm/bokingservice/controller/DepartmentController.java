package com.hrm.bokingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.bokingservice.dto.ApiResponse;
import com.hrm.bokingservice.dto.DepartmentDto;
import com.hrm.bokingservice.exception.BaseException;
import com.hrm.bokingservice.service.DepartmentService;
import com.hrm.bokingservice.vo.DepartmentVo;

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<String>> save(@RequestBody DepartmentVo data) {
		ApiResponse<String> response = null;
		try {
			String result = departmentService.saveDepartment(data);
			response = new ApiResponse<String>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (BaseException ex) {
			response = new ApiResponse<String>();
			response.setCode(ex.getCode());
			response.setData(ex.getMessage());
			response.setStatus(false);
			response.setMessage("fail");
		} catch (Exception ex) {
			response = new ApiResponse<String>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("server issue");
		}
		return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<ApiResponse<List<DepartmentDto>>> findAll() {
		ApiResponse<List<DepartmentDto>> response = null;
		try {
			List<DepartmentDto> result = departmentService.findAll();
			response = new ApiResponse<List<DepartmentDto>>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (Exception ex) {
			response = new ApiResponse<List<DepartmentDto>>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("fail");
		}
		return new ResponseEntity<ApiResponse<List<DepartmentDto>>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
	public ResponseEntity<ApiResponse<DepartmentDto>> findByDepartmentId(
			@PathVariable("departmentId") int departmentId) {
		ApiResponse<DepartmentDto> response = null;
		try {
			DepartmentDto result = departmentService.findById(departmentId);
			response = new ApiResponse<DepartmentDto>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (Exception ex) {
			response = new ApiResponse<DepartmentDto>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("fail");
		}
		return new ResponseEntity<ApiResponse<DepartmentDto>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<String>> update(@RequestBody DepartmentVo data) {
		ApiResponse<String> response = null;
		try {
			String result = departmentService.update(data);
			response = new ApiResponse<String>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (BaseException ex) {
			response = new ApiResponse<String>();
			response.setCode(ex.getCode());
			response.setData(ex.getMessage());
			response.setStatus(false);
			response.setMessage("fail");
		} catch (Exception ex) {
			response = new ApiResponse<String>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("server issue");
		}
		return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("departmentId") int departmentId) {
		ApiResponse<String> response = null;
		try {
			String result = departmentService.delete(departmentId);
			response = new ApiResponse<String>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (BaseException ex) {
			response = new ApiResponse<String>();
			response.setCode(ex.getCode());
			response.setData(ex.getMessage());
			response.setStatus(false);
			response.setMessage("fail");
		} catch (Exception ex) {
			response = new ApiResponse<String>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("fail");
		}
		return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/status", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<String>> status(@RequestParam("departmentId") int departmentId,
			@RequestParam("status") int status) {
		ApiResponse<String> response = null;
		try {
			String result = departmentService.setStatus(departmentId, status);
			response = new ApiResponse<String>();
			response.setCode(200);
			response.setData(result);
			response.setStatus(true);
			response.setMessage("success");
		} catch (BaseException ex) {
			response = new ApiResponse<String>();
			response.setCode(ex.getCode());
			response.setData(ex.getMessage());
			response.setStatus(false);
			response.setMessage("fail");
		} catch (Exception ex) {
			response = new ApiResponse<String>();
			response.setCode(400);
			response.setStatus(false);
			response.setMessage("fail");
		}
		return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
	}

}
