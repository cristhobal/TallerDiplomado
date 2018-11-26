package com.latam.pax.nimbus.persistence.exceptions;

/**
 * Class with the exception of the robot ReportHandlerException
 * @author ZentaGroup
 *
 */
public class UpdateException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UpdateException(String message) {
		super(message);
	}

	public UpdateException(Exception cause) {
		super(cause);
	}

	public UpdateException(String message, Exception cause) {
		super(message, cause);
	}

}
