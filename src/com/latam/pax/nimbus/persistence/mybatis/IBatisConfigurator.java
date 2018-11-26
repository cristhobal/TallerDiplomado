package com.latam.pax.nimbus.persistence.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latam.pax.nimbus.common.util.Constants;
import com.latam.pax.nimbus.common.util.PropertyUtil;

/**
 * Class responsible for initializing session persistence.
 * 
 * <p>
 * Record versions: 
 * <ul>
 * <li>1.0 13/04/2015, Zenta - initial release
 * </ul>
 * <p>
 * 
 * 
 * <p>
 * <B>All rights reserved LATAM.</B>
 */
public class IBatisConfigurator {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(IBatisConfigurator.class);

	/** The sql session. */
	private SqlSession sqlSession = null;

	/** The factory. */
	private SqlSessionFactory factory = null;	
	
	private String persistenceFileConfig = "";
	
	/**
	 * Instantiates a new i batis configurator.
	 */
	public IBatisConfigurator(String dbFileConfig) {
		this.persistenceFileConfig = dbFileConfig;
	}

	/**
	 * Gets the sql session.
	 * 
	 * @param resourceName
	 *            the resource name
	 * @param props
	 *            the props
	 * @param type
	 *            the type
	 * @return the sql session
	 * @throws IBatisConfiguratorException
	 *             the i batis configurator exception
	 */
	public synchronized SqlSession getSqlSession(ExecutorType type) throws IBatisConfiguratorException {
		PropertyUtil ppu = PropertyUtil.getInstance();
		Properties params;
		try {
			ppu.readProperties();
			params= ppu.getPropertiesFile();
			if (this.factory == null) {
				final Reader reader = Resources.getResourceAsReader(Constants.MYBATIS_CONFIG);
				if (logger.isDebugEnabled()) {
					logger.debug("Using " + this.persistenceFileConfig + " as reader ("
							+ reader + ")");
				}

				if (reader == null) {
					throw new IBatisConfiguratorException(
							"Can't open MyBatis config file. (" + this.persistenceFileConfig
									+ ")");
				}
				final SqlSessionFactoryBuilder factoryBuild = new SqlSessionFactoryBuilder();
				this.factory = factoryBuild.build(reader, params);
			}
			this.sqlSession = type != null ? factory.openSession(type) : factory
					.openSession();
			return this.sqlSession;
		} catch (IOException e) {
			throw new IBatisConfiguratorException(e);
		}

	}

	/**
	 * Returns the instance of the session persistence.
	 * 
	 * <p>
	 * Record versions:
	 * <ul>
	 * <li>1.0 13/04/2015, Zenta - initial release
	 * </ul>
	 * <p>
	 * 
	 * @return SqlSession, object instance session persistence.
	 * @throws IBatisConfiguratorException
	 *             the i batis configurator exception
	 * @since 1.0
	 */
	public SqlSession getSqlSession() throws IBatisConfiguratorException {
		if (this.sqlSession != null) {
			return this.sqlSession;
		}
		return null;

	}
}
