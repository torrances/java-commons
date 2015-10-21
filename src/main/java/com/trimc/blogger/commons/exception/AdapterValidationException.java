package com.trimc.blogger.commons.exception;

import com.trimc.blogger.commons.LogManager;

public class AdapterValidationException extends BusinessException {

	static LogManager logger = new LogManager(AdapterValidationException.class);

	private static final long serialVersionUID = 1L;

	private String message;

	private Object[] params;

	public AdapterValidationException(Exception e) {
		super(e);
	}

	public AdapterValidationException(Exception e, String message) {
		super(e, message);
	}

	public AdapterValidationException(String message) {
		super(message);
	}

	public AdapterValidationException(String message, Object... params) {
		this(String.format(message, params));
		this.params = params;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Object[] getParams() {
		return params;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
}
