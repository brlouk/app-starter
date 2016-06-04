package com.brlouk.starter.core.exceptions;

import java.text.MessageFormat;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = -5872433515219203599L;
	private final String code;
	private final Object[] args;

	public TechnicalException(TechnicalErrorEnum error, Throwable cause, Object... args) {
		super(error.getMessage(), cause);
		this.code = error.getCode();
		this.args = args;
	}
	
	public TechnicalException(String code, String message, Throwable cause, Object... args) {
		super(message, cause);
		this.code = code;
		this.args = args;
	}

	public String getCode() {
		return this.code;
	}
	
	public Object[] getArgs() {
		return args;
	}
	
	public String getMessage() {
		if (args != null) {
			return MessageFormat.format(super.getMessage(), args);
		}
		return super.getMessage();
	}

}
