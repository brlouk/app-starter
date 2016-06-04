package com.brlouk.starter.core.exceptions;

import java.text.MessageFormat;

public class FunctionalError {

	private final FunctionalErrorEnum error;
	private final Object[] args;

	public FunctionalError(FunctionalErrorEnum error, Object... args) {
		super();
		this.error = error;
		this.args = args;
	}

	public FunctionalError(FunctionalErrorEnum error) {
		super();
		this.error = error;
		this.args = null;
	}

	public FunctionalErrorEnum getError() {
		return error;
	}

	public Object[] getArgs() {
		return args;
	}

	public String getMessage() {
		if (error != null) {
			if (args != null) {
				return MessageFormat.format(error.getMessage(), args);
			}
			return error.getMessage();
		}
		return "no functional error message defined";
	}

}
