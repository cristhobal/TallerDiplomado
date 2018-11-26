package com.latam.pax.nimbus.persistence.services;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.domain.AspectGcpEvaluated;
import com.latam.pax.nimbus.domain.CrewMember;
import com.latam.pax.nimbus.domain.Question;
import com.latam.pax.nimbus.domain.Report;
import com.latam.pax.nimbus.domain.ResultGCP4JSB;
import com.latam.pax.nimbus.persistence.mybatis.IBatisConfigurator;
import com.latam.pax.nimbus.persistence.mybatis.IBatisConfiguratorException;

/**
 * Class containing the method implementations MC Rates
 * @author ZentaGroup
 *
 */
public class ReportServices {

	private static final Logger logger = Logger.getLogger(ReportServices.class);
	static java.util.Date fecha = new Date();
	private static final String IBATISCONF="com/latam/pax/nimbus/persistence/config/PersistenceConfigOne.xml";
	private IBatisConfigurator db1 = new IBatisConfigurator(IBATISCONF);
	private SqlSession session1 = null;

	public ReportMapper connectMapper() throws BatchException {

		try {
			if (null == session1) {
				session1 = db1.getSqlSession(ExecutorType.BATCH);
			}
		} catch (IBatisConfiguratorException e) {			
			closeMapper();
			logger.error(e.getMessage(), e);
			throw new BatchException();
		}
		return session1.getMapper(ReportMapper.class);
		 
	}
	
	public List<Question> getQuestion() throws BatchException {
		 ReportMapper mapper = connectMapper();
		 
		 try{
			return mapper.getQuestion();
		 }catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 throw new BatchException(e);
		 }finally{
			 closeMapper();
		 }
	}
	
	public List<Report> getReport() throws BatchException {
		 ReportMapper mapper = connectMapper();
		 
		 try{
			return mapper.getReport();
		 }catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 throw new BatchException(e);
		 }finally{
			 closeMapper();
		 }
	}
	
	public ResultGCP4JSB detailGcp(String reportId) throws BatchException {
		 ReportMapper mapper = connectMapper();
		 
		 try{
			return mapper.detailGcp(reportId);
		 }catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 throw new BatchException(e);
		 }finally{
			 closeMapper();
		 }
	}
	
	public CrewMember getCrewByBp2(CrewMember crewMember) throws BatchException {
		 ReportMapper mapper = connectMapper();
		 
		 try{
			return mapper.getCrewByBp(crewMember);
		 }catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 throw new BatchException(e);
		 }finally{
			 closeMapper();
		 }
	}
	
	public List<AspectGcpEvaluated> getQuestionGCPAnswered(String code) throws BatchException {
		 ReportMapper mapper = connectMapper();
		 
		 try{
			return mapper.getQuestionGCPAnswered(code);
		 }catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 throw new BatchException(e);
		 }finally{
			 closeMapper();
		 }
	}
	
	

	public void closeMapper() {
		if(null!=session1){
		session1.close();
		session1=null;
		}
	}
}
