package com.springboot.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//The {@code ErrorResponse} class represents Error Responses
// @author Bhanu jogi

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse {

	private boolean success;
	private String errormsg;
	
	
	public SuccessResponse(boolean success, String errormsg) {
		super();
		this.success = success;
		this.errormsg = errormsg;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getErrormsg() {
		return errormsg;
	}


	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}


	
	
}
