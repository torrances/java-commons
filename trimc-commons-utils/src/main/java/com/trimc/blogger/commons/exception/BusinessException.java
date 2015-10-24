package com.trimc.blogger.commons.exception;

import com.trimc.blogger.commons.LogManager;

public class BusinessException extends Exception {

	static LogManager logger = new LogManager(BusinessException.class);

	private static final long serialVersionUID = 1L;

	private String message;

	private Object[] params;

	public BusinessException(Exception e) {
		logger.error(e);
		setMessage(e.getMessage());
	}

	public BusinessException(Exception e, String message) {
		logger.error(e);
		setMessage(message);
	}

	public BusinessException(Exception e, String message, Object... params) {
		this(String.format(message, params));
		logger.error(e);
	}

	public BusinessException(String message) {
		message = (null == message || 0 == message.length()) ? "Undefined Error Message" : message;
		setMessage(message);
	}

	public BusinessException(String message, Object... params) {
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
