package com.revature.latza.exceptions;

public class PatientAlreadyPresentException extends RuntimeException {
	public PatientAlreadyPresentException() {}

	public PatientAlreadyPresentException(String message) {super(message);}

	public PatientAlreadyPresentException(Throwable cause) {super(cause);}

	public PatientAlreadyPresentException(String message, Throwable cause) {super(message, cause);}

	public PatientAlreadyPresentException(String message, Throwable cause, boolean enableSuppression,boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
