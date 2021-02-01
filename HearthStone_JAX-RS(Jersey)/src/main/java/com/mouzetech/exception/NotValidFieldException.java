package com.mouzetech.exception;

import com.mouzetech.resource.exception.ValidationError;

public class NotValidFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ValidationError error;
	
	public NotValidFieldException(ValidationError error) {
		super();
		this.error = error;
	}

	public ValidationError getError() {
		return error;
	}

	public void setError(ValidationError error) {
		this.error = error;
	}	
}