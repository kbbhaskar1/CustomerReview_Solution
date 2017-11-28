package com.org.customerreviews.exception;

import java.util.List;


public class ErrorResponse {
	private int errorCode;
	private String errorMessage;
	private List<String> errors;
	
	//constructor
	public ErrorResponse(){
		
	}
	
	//setters
	public void setErrorCode(int errorCode){
		this.errorCode = errorCode;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	//getters
	public int getErrorCode(){
		return this.errorCode;
	}
	public String getErrorMessage(){
		return this.errorMessage;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
