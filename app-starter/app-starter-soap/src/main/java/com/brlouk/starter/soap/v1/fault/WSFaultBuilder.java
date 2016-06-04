package com.brlouk.starter.soap.v1.fault;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.brlouk.starter.core.exceptions.FunctionalError;
import com.brlouk.starter.core.exceptions.FunctionalException;
import com.brlouk.starter.core.exceptions.MultiFunctionalErrors;
import com.brlouk.starter.core.exceptions.TechnicalException;
import com.brlouk.starter.soap.v1.user.WSFaultException;

/**
 * Builder for WS Fault
 * 
 */
public final class WSFaultBuilder {

	
	private WSFaultBuilder(){
	}
	
	/**
	 * Create a Technical Fault for the given exception
	 * 
	 * @param ex
	 * @return
	 */
	public static WSFaultException createTechnicalFault(
			TechnicalException ex) {
		return createSingleTechnicalFault(ex.getCode(), ex.getMessage(), null,
				ex.getArgs());

	}

	/**
	 * Create a Technical Fault based on the given arguments
	 * 
	 * @param code
	 * @param message
	 * @param params
	 * @return
	 */
	public static WSFaultException createSingleTechnicalFault(String code,
			String message, Throwable cause, Object... params) {

		WSFault wsFault = new WSFault();
		WSFaultTechnicalType wsFaultTechnicalType = new WSFaultTechnicalType();
		wsFaultTechnicalType.setCode(code);

		WSMessageType messageType = new WSMessageType();
		if (params == null) {
			messageType.setText(message);
		} else {
			messageType.getParams().addAll(Arrays.asList(params));
			messageType.setText(MessageFormat.format(message, params));
		}
		wsFaultTechnicalType.setMessage(messageType);

		wsFault.setWSFaultTechnical(wsFaultTechnicalType);

		WSFaultException faultException = new WSFaultException(message,
				wsFault, cause);
		return faultException;

	}

	/**
	 * Create Functional fault for the given exception
	 * 
	 * @param functionalException
	 * @return
	 */
	public static WSFaultException createFunctionalFault(
			FunctionalException functionalException) {

		List<WSFaultException> toReturn = new ArrayList<WSFaultException>();
		MultiFunctionalErrors mfe = functionalException.getErrors();
		if (mfe != null) {
			List<FunctionalError> errors = mfe.getErrors();
			for (FunctionalError error : errors) {
				WSFaultException fault = createSingleFunctionalFault(error
						.getError().name(), error.getMessage(), error.getArgs());
				toReturn.add(fault);
			}
		}
		return createMultiFunctionalFault(toReturn
				.toArray(new WSFaultException[toReturn.size()]));

	}

	/**
	 * Create a Multi functional fault
	 * 
	 * @param wsFaultExceptions
	 * @return
	 */
	public static WSFaultException createMultiFunctionalFault(
			WSFaultException... wsFaultExceptions) {

		if (wsFaultExceptions != null) {
			WSFaultException faultException = new WSFaultException(
					wsFaultExceptions[0].getMessage(), new WSFault());
			for (WSFaultException wsFaultException : wsFaultExceptions) {
				List<WSFaultFunctionalType> wsFaultFunctionals = wsFaultException
						.getFaultInfo().getWSFaultFunctionals();
				faultException.getFaultInfo().getWSFaultFunctionals()
						.addAll(wsFaultFunctionals);
			}
			return faultException;
		}
		return new WSFaultException("Unknown fault!");

	}

	/**
	 * Create a functional fault based on the given arguments
	 * 
	 * @param code
	 * @param message
	 * @param params
	 * @return
	 */
	public static WSFaultException createSingleFunctionalFault(String code,
			String message, Object... params) {
		WSFault wsFault = new WSFault();
		WSFaultFunctionalType wsFaultFunctionalType = new WSFaultFunctionalType();
		wsFaultFunctionalType.setCode(code);

		WSMessageType messageType = new WSMessageType();
		if (params == null) {
			messageType.setText(message);
		} else {
			messageType.getParams().addAll(Arrays.asList(params));
			messageType.setText(MessageFormat.format(message, params));
		}
		wsFaultFunctionalType.setMessage(messageType);

		wsFault.getWSFaultFunctionals().add(wsFaultFunctionalType);

		WSFaultException faultException = new WSFaultException(message, wsFault);
		return faultException;

	}

	/**
	 * Create a WS Operation fault
	 * 
	 * @param technicalEnum
	 * @param traceId
	 * @param params
	 * @return
	 */
	public static WSFaultException createOperationFault(
			WSOperationFaultEnum technicalEnum, Object... params) {
		return createSingleTechnicalFault(technicalEnum.getCode(),
				technicalEnum.getMessage(), null, params);
	}
	
	/**
	 * Create a WS Operation fault
	 * 
	 * @param technicalEnum
	 * @param traceId
	 * @param params
	 * @param cause
	 * @return
	 */
	public static WSFaultException createOperationFault(
			WSOperationFaultEnum technicalEnum, Throwable cause, Object... params) {
		return createSingleTechnicalFault(technicalEnum.getCode(),
				technicalEnum.getMessage(), cause, params);
	}

}
