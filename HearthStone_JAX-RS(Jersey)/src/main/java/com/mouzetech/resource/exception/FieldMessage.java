package com.mouzetech.resource.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;


	public FieldMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
