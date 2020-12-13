package com.project.rover.exception;

public class RoverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;

	public RoverException(String errorMsg) {
		super();
		this.setErrorMsg(errorMsg);
	}

	public RoverException() {
		super();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	

}
