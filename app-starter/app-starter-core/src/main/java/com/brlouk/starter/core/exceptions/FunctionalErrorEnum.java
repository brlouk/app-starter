package com.brlouk.starter.core.exceptions;

public enum FunctionalErrorEnum {

	F0001("Functional Error...");

	private String message;

	private FunctionalErrorEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
