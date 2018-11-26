package com.latam.pax.nimbus.process.batchprocess;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.lanchile.framework.batch.BatchException;
import com.lanchile.framework.batch.BatchInfo;
import com.lanchile.framework.batch.WorkDescriptor;
import com.lanchile.framework.batch.WorkManager;
import com.lanchile.framework.batch.jmx.FrameworkBatchAgent;
import com.lanchile.library.io.FileUtils;
import com.latam.pax.nimbus.common.util.Constants;

public class BatchJobExecutorLocal {
	public static final String USAGE = "Framework Batch Version: 1.0.7\nUsage: java com.lanchile.framework.batch.BatchJobExecutor <config file> <flag test> <reproceso> [job id]";
	private static final Logger logger = Logger.getLogger(BatchJobExecutorLocal.class);
	static String arg;

	private BatchJobExecutorLocal() {
		//This is to hide the implicit public constructor
	}

	public static void initJobExecutor(String fileName, Properties props)
			throws BatchException
	{
		try
		{
			File file = FileUtils.findFirstFileInClasspath(fileName);

			if (file == null) {
				throw new BatchException(176, "EAP0006 No se encontro el archivo de configuracion " + fileName);
			}
			props.load(new FileInputStream(file));
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new BatchException(177, "EAP0007 No se pudo cargar el archivo de configuracion " + fileName);
		}
	}

	public static void initLog4J(String fileName) throws BatchException
	{
		try {
			File file = FileUtils.findFirstFileInClasspath(fileName);

			if (file == null) {
				throw new BatchException(173, "EAP0003 No se encontro el archivo de configuracion de LOG4J " + fileName);
			}
			Properties props = new Properties();
			props.load(new FileInputStream(file));
			PropertyConfigurator.configure(props);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			throw new BatchException(174, "EAP0004 No se pudo cargar el archivo de configuracion de LOG4J " + fileName);
		}
	}

	public static void loadProcessConfig(String fileName, Properties props) throws BatchException
	{
		try {
			if ((fileName != null) && (fileName.length() > 0)) {
				File file = new File(fileName);
				props.load(new FileInputStream(file));
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new BatchException(177, "EAP0007 No se pudo cargar el archivo de configuracion " + fileName);
		}
	}

	public static void main(String[] args)
	{
		boolean flagTest = false;
		boolean flagReproceso = false;
		String jobId = "";
		arg= args[3];

		FrameworkBatchAgent fwBatchAgent = new FrameworkBatchAgent();
		BatchInfo batchInfo = BatchInfo.getInstance();

		batchInfo.setRc(0);

		String configFile = args[0];
		if (Constants.TRUE.equalsIgnoreCase(args[1]))
			flagTest = true;
		if (Constants.TRUE.equalsIgnoreCase(args[2])) {
			flagReproceso = true;
			if (args.length != 4) {
				System.exit(172);
			}
			jobId = args[3];
		}
		batchInfo.setFlagReproceso(flagReproceso);

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		String jobDateBegin = formatDate.format(new Date(System.currentTimeMillis()));
		try
		{
			validateMethod(flagTest, flagReproceso, configFile, jobId, fwBatchAgent, batchInfo, jobDateBegin);
		}
		catch (BatchException e)
		{
			logger.error(e.getMessage(),e);
			logger.error("[run] BatchException: " + e.toString());
			batchInfo.setError(e.toString());
			batchInfo.setRc(e.getRC());
			if (batchInfo.getRc() == 0)
				batchInfo.setRc(182);
		}
		catch (Exception e)
		{
			logger.error("[run] Exception: " + e);
			batchInfo.setError("EAP0012 Error inesperado, " + e.toString());
			batchInfo.setRc(182);
		}

	}

	@SuppressWarnings("unchecked")
	private static void validateMethod(boolean flagTest, boolean flagReproceso, String configFile, String jobq,
			FrameworkBatchAgent fwBatchAgent, BatchInfo batchInfo, String jobDateBegin)
					throws BatchException {
		long t1;
		long t2;
		SimpleDateFormat formatDate;
		String jobName;
		t1 = System.currentTimeMillis();

		Properties props = new Properties();
		initJobExecutor(configFile, props);
		int noThreads = Integer.parseInt(props.getProperty("batch.nothreads", "3"));
		jobName = props.getProperty("batch.jobname", "");
		String chunker = props.getProperty("batch.chunker", "");
		String worker = props.getProperty("batch.worker", "");
		String errorHandler = props.getProperty("batch.errorhandler", "");
		String log4jFile = props.getProperty("batch.filename.log4j", "");
		String processConfigFile = props.getProperty("batch.process.configfile", "");
		String tmp = props.getProperty("batch.runmode", "server");
		int chunkSize = Integer.parseInt(props.getProperty("batch.chunksize", "30"));
		int jmxPort = Integer.parseInt(props.getProperty("batch.jmxport", "9090"));
		boolean appServer = false;
		if (Constants.SERVER.equalsIgnoreCase(tmp)) {
			appServer = true;
		}
		tmp = props.getProperty("batch.format.time", "true");
		if (Constants.FALSE.equalsIgnoreCase(tmp))
			batchInfo.setFormatTime(false);
		else {
			batchInfo.setFormatTime(true);
		}

		formatDate = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String jobDate = formatDate.format(new Date(System.currentTimeMillis()));
		String jobbI=jobq;
		if (!flagReproceso)
			jobbI = jobDate;

		batchInfo.setJobDateBegin(jobDateBegin);
		batchInfo.setJobName(jobName);
		batchInfo.setJobId(jobbI);
		batchInfo.setThreadSize(noThreads);
		batchInfo.setChunkerClass(chunker);
		batchInfo.setWorkerClass(worker);
		batchInfo.setErrorHandlerClass(errorHandler);
		batchInfo.setChunkSize(chunkSize);
		if (appServer)
			batchInfo.setRunMode("server");
		else {
			batchInfo.setRunMode("standalone");
		}

		initLog4J(log4jFile);

		Properties propsProcess = new Properties();
		loadProcessConfig(processConfigFile, propsProcess);
		Iterator<Object> it = propsProcess.keySet().iterator();
		while (it.hasNext()) {
			String key = (String)it.next();
			String value = propsProcess.getProperty(key);
			props.setProperty(key, value);
		}
		batchInfo.setPropsProcess(propsProcess);

		try {
			fwBatchAgent.init(jmxPort);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}

		WorkDescriptor d = new WorkDescriptor(props, jobName);
		d.put("batch.reprocess", (boolean)(flagReproceso));
		d.put("batch.jobid", jobbI);
		d.setWorker(worker);
		d.setChunker(chunker);
		d.setErrorHandler(errorHandler);

		WorkManager mgr = new WorkManager(appServer, flagTest, noThreads, d);
		batchInfo.setWorkManager(mgr);
		mgr.init();
		mgr.runJob();

		t2 = System.currentTimeMillis();
		logger.info("[main] Tiempo de total de procesamiento: " + (t2 - t1) + " ms.");
		batchInfo.setTotalProcessTime(t2 - t1);
	}


}