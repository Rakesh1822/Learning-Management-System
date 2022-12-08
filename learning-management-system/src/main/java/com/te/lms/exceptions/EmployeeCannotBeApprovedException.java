package com.te.lms.exceptions;

public class EmployeeCannotBeApprovedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeCannotBeApprovedException(String message) {
		super(message);
	}

}
