package com.springboot.response;

public class DataNotFoundException extends RuntimeException{
	
	
	//UNIQUE VALUE FOR SERIALIZATION
	private static final long serialVersionUID = 1L;
	
	
	//constructs a new "DataNotFoundException" with specified detailed message
	//message a descriptive message indicating the cause of the exception.
	public DataNotFoundException(String message) {
		
		super(message);
	}

}
