package com.StudentManagement.Exception;

public class AccessDeniedException extends Exception {

	public AccessDeniedException() {
		super();
	}
	
	public AccessDeniedException(String message) {
		super(message);
	}
}
