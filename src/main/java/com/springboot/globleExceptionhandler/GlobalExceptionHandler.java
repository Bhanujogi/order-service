package com.springboot.globleExceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.model.Constants;
import com.springboot.response.DataNotFoundException;
import com.springboot.response.ErrorResponse;
import com.springboot.response.SuccessResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {

	private final Logger mLogger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(MethodArgumentNotValidException Exception) {
		final List<Map<String, String>> lFiledValidationErrors = Exception.getBindingResult().getAllErrors().stream()
				.filter(FieldError.class::isInstance).map(FieldError.class::cast).map(lFieldError -> {
					final Map<String, String> lErrorsMap = new HashMap<>();
					lErrorsMap.put(lFieldError.getField(), lFieldError.getDefaultMessage());
					return lErrorsMap;
				}).toList();
		mLogger.error(Exception.getMessage(), Exception);
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(false, Constants.REQUEST_VALIDATION_ERRORS, lFiledValidationErrors),
				HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<SuccessResponse> handleDataNotFoundException(
			final DataNotFoundException dataNotFoundException) {

		mLogger.error(dataNotFoundException.getMessage(), dataNotFoundException);

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new SuccessResponse(false, dataNotFoundException.getMessage()));

	}

}
