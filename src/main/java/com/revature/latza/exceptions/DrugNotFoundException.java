package com.revature.latza.exceptions;

public class DrugNotFoundException extends RuntimeException {
	public DrugNotFoundException() {}

	public DrugNotFoundException(String message) {super(message);}

	public DrugNotFoundException(Throwable cause) {super(cause);}

	public DrugNotFoundException(String message, Throwable cause) {super(message, cause);}

	public DrugNotFoundException(String message, Throwable cause, boolean enableSuppression,boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
