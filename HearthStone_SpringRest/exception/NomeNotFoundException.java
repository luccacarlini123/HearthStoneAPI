package com.mouzetech.exception;

public class NomeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NomeNotFoundException(String msg) {
		super(msg);
	}

}
