package com.latam.pax.nimbus.persistence.mybatis;

/**
 * The Class IBatisConfiguratorException.
 */
public class IBatisConfiguratorException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9163031343242918005L;

	/**
	 * Instantiates a new i batis configurator exception.
	 */
	IBatisConfiguratorException() {
	}

	/**
	 * Instantiates a new i batis configurator exception.
	 *
	 * @param message the message
	 */
	IBatisConfiguratorException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new i batis configurator exception.
	 *
	 * @param cause the cause
	 */
	IBatisConfiguratorException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new i batis configurator exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	IBatisConfiguratorException(String message, Throwable cause) {
		super(message, cause);
	}
}
