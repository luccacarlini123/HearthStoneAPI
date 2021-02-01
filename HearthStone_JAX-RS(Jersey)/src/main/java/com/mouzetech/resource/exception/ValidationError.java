package com.mouzetech.resource.exception;

import java.io.Serializable;
import java.util.List;

public class ValidationError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private List<FieldMessage> messages;

	public ValidationError(Long timeStamp, Integer status, String error, String message, String path, List<FieldMessage> messages) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.messages = messages;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<FieldMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<FieldMessage> messages) {
		this.messages = messages;
	}
}