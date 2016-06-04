package com.brlouk.starter.core.exceptions;

public class FunctionalException extends Exception {

	private final MultiFunctionalErrors errors;

	private static final long serialVersionUID = -2187000591619821907L;

	public FunctionalException(MultiFunctionalErrors errors) {
		this.errors = errors;
	}

	public FunctionalException(FunctionalErrorEnum error, Object... args) {

		this.errors = new MultiFunctionalErrors();
		errors.getErrors().add(new FunctionalError(error, args));
	}

	public MultiFunctionalErrors getErrors() {
		return errors;
	}

	@Override
	public String getMessage() {
		if (errors != null && errors.getErrors() != null && !errors.getErrors().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for(FunctionalError fer : errors.getErrors()){
				sb.append(fer.getMessage()).append(System.lineSeparator());
			}
			return sb.toString();
		}
		return "no functional error message defined";
	}

}
