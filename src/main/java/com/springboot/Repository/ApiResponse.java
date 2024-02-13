package com.springboot.Repository;

import lombok.Data;

//ApiResponse.java

@Data
public class ApiResponse {


	private boolean success;
	private String successMsg;

	// Constructors, getters and setters

	public ApiResponse(boolean success, String successMsg) {
		super();
		this.success = success;
		this.successMsg = successMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	@Override
	public String toString() {
		return "ApiResponse [success=" + success + ", successMsg=" + successMsg + "]";
	}

}
