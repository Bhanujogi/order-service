package com.springboot.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code ErrorResponse} class represents Error Responses
 * @author Bhanu jogi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
   
	/**
     * The success takes values of type boolean
     */
    private boolean success;
    /**
     * The errorMessage takes values of type string
     */
    private String errorMessage;
    /**
     * The fieldErrors takes values of type List
     */
    private List<Map<String, String>> fieldErrors;
    
	public ErrorResponse(boolean success, String errorMessage, List<Map<String, String>> fieldErrors) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
		this.fieldErrors = fieldErrors;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Map<String, String>> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<Map<String, String>> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
    
    
    
    
    
}