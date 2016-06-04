package com.brlouk.starter.soap.v1.fault;

/**
 * Enumerates all technical fault operations a web service can throw
 * 
 */
public enum WSOperationFaultEnum {

	OP0001("OP0001", "Not implemented yet!");

	private String code;
	private String message;

	private WSOperationFaultEnum(String code, String message) {
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
