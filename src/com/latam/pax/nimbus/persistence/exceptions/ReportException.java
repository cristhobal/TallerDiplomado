package com.latam.pax.nimbus.persistence.exceptions;

/**
 * Class with the exception of the robot ReportHandlerException
 * @author ZentaGroup
 *
 */
public class ReportException extends Exception{
	private static final long serialVersionUID = 1L;

	public ReportException(String message) {
		super(message);
	}

	public ReportException(Exception cause) {
		super(cause);
	}

	public ReportException(String message, Exception cause) {
		super(message, cause);
	}

}
