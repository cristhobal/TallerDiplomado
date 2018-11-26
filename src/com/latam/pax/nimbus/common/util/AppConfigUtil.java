package com.latam.pax.nimbus.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.persistence.exceptions.ReportException;

/**
 * Class containing the configuration file of the application
 * @author ZentaGroup
 *
 */
public class AppConfigUtil {
	private static final HashMap<String, AppConfigUtil> instances 	= new HashMap<>();
	private static final Logger 						logger		= Logger.getLogger(AppConfigUtil.class);
	private static ClassLoader 	classLoader			= null;
	private static String 		appFolder 			= null;
	private static String 		defaultConfigFile 	= null;
	private String 		configFile;
	private Properties 	properties;

    /**
     * class constructor method
     */
	public AppConfigUtil() {
		//Constructor
	}
	
	/**
	 * Reload set config file properties.
	 * @throws Exception 
	 * @throws RobotListenerEmail
	 */
	private AppConfigUtil(String configFile) throws BatchException{
		logger.info(  "AppConfig created for file: " + configFile );
		this.configFile = configFile;
		this.properties = new Properties();
		loadProperties();
	}
	
	/**
	 * Get the instance for the stored config file.
	 * @return The instance associated to the config file.
	 * @throws Exception 
	 */
	public static synchronized AppConfigUtil getInstance() throws BatchException {
		return getInstance(null);
	}

	/**
	 * Get the instance for the stored config file.
	 * @param configFilename
	 * @return The instance associated to the config file.
	 * @throws Exception 
	 */
	public static synchronized AppConfigUtil getInstance( String configFilename ) throws BatchException {
		String conf=configFilename;
		if ( (null==conf) || (conf.trim().isEmpty()) ){
			conf = defaultConfigFile;
		}

		AppConfigUtil instance = instances.get(conf);
		if (instance == null){
			instance = new AppConfigUtil( conf );
			instances.put(conf, instance);
		}

		return instance;
	}
	/**
	 * Reload all the managed properties.
	 * @throws Exception 
	 */
	static synchronized void reloadProperties() throws BatchException{
		for(AppConfigUtil instance:instances.values()){
			instance.loadProperties();
		}
	}
	

	/**
	 * Return the Properties object for the AppConfig instance.
	 * @return
	 */
	public Properties getProperties(){
		return this.properties;
	}

	/**
	 * Load settings of properties
	 * @return
	 */
	private void loadProperties() throws BatchException{
		InputStream is = null;
		try {
			is = classLoader.getResourceAsStream( appFolder + "/" + configFile );
			if (is==null){
				throw new BatchException("Can't find the application properties file.(" + appFolder + "/" + configFile);
			}
			properties.load( is );
			logger.info( "Successfully Loaded properties from " + configFile );

		} catch (IOException e) {
			throw new BatchException("An exception occurred while trying to read content of file "
					+ configFile, e);
		}
		finally {
			if(null!=is){
			try {
				is.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
			}
		}
	}

	/**
	 * Set defaults for the AppConfig files.
	 * @param classLoader
	 * @param appFolder
	 * @param defaultConfigFile
	 * @throws ReportException
	 */
	public static void setDefaultConfigFile(ClassLoader classLoader, String appFolder, String defaultConfigFile) throws ReportException {
		logger.info("Setting default app-config folder to " + appFolder );
		logger.info("Setting default config file to " + defaultConfigFile );
		AppConfigUtil.classLoader = classLoader;
		AppConfigUtil.appFolder = appFolder;
		AppConfigUtil.defaultConfigFile = defaultConfigFile;

		try {
			getInstance(defaultConfigFile);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

/**
 * method that obtains the date of action
 * @return
 * @throws ParseException
 */
	public String getFchAction() {
		Date fchInsert= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(fchInsert);
	}

}
