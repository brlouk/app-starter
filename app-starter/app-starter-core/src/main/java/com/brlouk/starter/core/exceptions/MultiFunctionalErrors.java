package com.brlouk.starter.core.exceptions;

import java.util.ArrayList;
import java.util.List;

public class MultiFunctionalErrors {

	private final List<FunctionalError> errors = new ArrayList<FunctionalError>();

	public boolean isEmpty() {
		return errors.isEmpty();
	}

	public void addFunctionalError(FunctionalErrorEnum error) {
		getErrors().add(new FunctionalError(error));
	}

	public void addFunctionalError(FunctionalErrorEnum error, Object... args) {
		getErrors().add(new FunctionalError(error, args));
	}

	public List<FunctionalError> getErrors() {
		return errors;
	}

}
