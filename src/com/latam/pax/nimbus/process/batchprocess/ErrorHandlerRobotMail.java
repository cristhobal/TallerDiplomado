package com.latam.pax.nimbus.process.batchprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lanchile.framework.batch.ErrorHandler;
import com.lanchile.framework.batch.WorkDescriptor;



/**
 * Clase que implementa ErrorHandler, la cual permite el manejo de errores asociados a la ejecucion de un proceso batch.
 *
 */
public class ErrorHandlerRobotMail implements ErrorHandler {

	private static final long serialVersionUID = -7708928293056092717L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerRobotMail.class);

	@Override
	public boolean continueJobExecution() {
		return false;
	}

	@Override
	public void processError(WorkDescriptor workDescriptor, Exception exception) {
		// No se envia correo ya que esto se maneja en el worker.
		LOGGER.error("Error al procesar Workernimbus [" + workDescriptor.getID() + "]", exception);

	}

}
