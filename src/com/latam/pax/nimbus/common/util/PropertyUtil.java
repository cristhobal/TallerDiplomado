package com.latam.pax.nimbus.common.util;

	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	

	/**
	* Clase que implementa los servicios del archivo properties.
	*
	*/
	public final class PropertyUtil {

	private static final PropertyUtil INSTANCE = new PropertyUtil();

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);

	private Properties propertiesFile;

	private PropertyUtil() {

	}

	public static PropertyUtil getInstance() {
	return INSTANCE;
	}

	protected Properties getProperty(String property) throws IOException {
	FileInputStream fis = new FileInputStream(property);
	Properties prop = new Properties();
	prop.load(fis);
	return prop;
	}

	/**
	* Lee las propiedades desde los archivos de configuracion
	* config.properties, db.properties, log4j.properties
	* 
	* @throws IOException
	*/
	public void readProperties() throws IOException {
			
	try {

		propertiesFile = getProperty(Constants.LOADDICTPROP);
	if (LOGGER.isDebugEnabled()) {
	LOGGER.debug("Reading properties [" + Constants.LOADDICTPROP + "]");
	}

	} catch (IOException ioException) {
	LOGGER.error("Not found . " + Constants.LOADDICTPROP, ioException);
	throw ioException;
	}
	
  }

	public Properties getPropertiesFile() {
		return propertiesFile;
	}

	public void setPropertiesFile(Properties propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	
}
	

