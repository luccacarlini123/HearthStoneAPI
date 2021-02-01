package com.mouzetech.exception;

import java.util.List;

public class FieldValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FieldValidationException(List<String> msg) {
		super(msg.toString());
	}
}
