package com.hrm.bokingservice.dto;

/*
 *  purpose :  response is sent with this container for every request
 * 
 */
public class ApiResponse<T> {

	private T data;
	private int code;
	private String message;
	private boolean status;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
