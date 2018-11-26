package com.latam.pax.nimbus.business;

import java.util.Properties;
import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.common.util.SendMail;

/**
 * 
 * @author Robregons
 *
 */
public class RobotMail {

	protected static Properties prop;
	
	
	/**
	 * Constructor
	 */
	protected RobotMail(){
		//This is a Constructor
	}
	
	public static void startRobotMail() throws BatchException{
		SendMail.sendMailGcp();
	}

}