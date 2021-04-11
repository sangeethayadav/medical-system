package com.hrm.bokingservice.dto;

import java.math.BigInteger;

public class FeedbackDto {
	
	private String name;
	private String email;
	private BigInteger number;
	private String query;
	private String status;
	private int departmetId;
	private String formType;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getNumber() {
		return number;
	}

	public void setNumber(BigInteger number) {
		this.number = number;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDepartmetId() {
		return departmetId;
	}

	public void setDepartmetId(int departmetId) {
		this.departmetId = departmetId;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

}
