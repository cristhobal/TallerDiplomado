package com.latam.pax.nimbus.process.wrapper;

import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latam.pax.nimbus.common.util.Constants;
import com.latam.pax.nimbus.process.batchprocess.BatchJobExecutorLocal;


/**
 * Clase principal de inicio de ejecucion
 * @author Hugo
 *
 */
public class WrapperRobotMail {
	private static final Logger logger = LoggerFactory.getLogger(WrapperRobotMail.class);
	private static int exit = 0;
	
	private WrapperRobotMail() {
		//This is a Constructor
	}
	
	public static int getExit() {
		return exit;
	}
	public static void setExit(int exit) {
		WrapperRobotMail.exit = exit;
	}
	
	/**
	 * Principal method used to activate the process of LoadDictTransferPrice
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		final Date startDate = new Date();
		String[] params = new String[] {
				"../config/frameworkBatch.properties", "false", "false", "1" };
		logger.info(Constants.LOGGER_START_REPORT_PROCESS+startDate);
		BatchJobExecutorLocal.main(params);
		System.exit(exit);
	}

}
