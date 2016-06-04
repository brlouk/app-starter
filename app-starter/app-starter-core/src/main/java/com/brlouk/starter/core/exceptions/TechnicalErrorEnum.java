package com.brlouk.starter.core.exceptions;

public enum TechnicalErrorEnum {
	
	T0001("T0001","Une erreur technique inattendue est survenue...");

	private String code;
	private String message;

	private TechnicalErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
