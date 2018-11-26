package com.latam.pax.nimbus.process.batchprocess;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanchile.framework.batch.BatchException;
import com.lanchile.framework.batch.WorkDescriptor;
import com.lanchile.framework.batch.Worker;
import com.latam.pax.nimbus.business.RobotMail;
import com.latam.pax.nimbus.common.util.PropertyUtil;
import com.latam.pax.nimbus.persistence.services.ReportServices;
import com.latam.pax.nimbus.process.wrapper.WrapperRobotMail;

public class WorkerRobotMail implements Worker {

	private static final Logger logger = LoggerFactory.getLogger(WorkerRobotMail.class);
	ReportServices mp = new ReportServices();

	@Override
	public void executeChunk(WorkDescriptor wd) throws BatchException {
		try{
			PropertyUtil.getInstance().readProperties();
			RobotMail.startRobotMail();
			logger.info("Iniciate Robot SUCCESFULL!");
		}catch (BatchException  | IOException e) {
			logger.error(e.getMessage(),e);
			logger.error("Send Mail FAILED");
			WrapperRobotMail.setExit(-1);
		}

	}

	@Override
	public void executeChunkTest(WorkDescriptor arg0) throws BatchException {
		 //Constructor to hide implicit public one
	}


}
