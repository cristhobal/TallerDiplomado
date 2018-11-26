package com.latam.pax.nimbus.persistence.services;

import java.util.List;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.domain.AspectGcpEvaluated;
import com.latam.pax.nimbus.domain.CrewMember;
import com.latam.pax.nimbus.domain.Question;
import com.latam.pax.nimbus.domain.Report;
import com.latam.pax.nimbus.domain.ResultGCP4JSB;

/**
 * 
 * @author ZentaGroup
 *
 */
public interface ReportMapper {

	public List<Question> getQuestion() throws BatchException;
	public List<Report> getReport() throws BatchException;
	public ResultGCP4JSB detailGcp(String reportId) throws BatchException;
	public List<AspectGcpEvaluated> getQuestionGCPAnswered(String reportId) throws BatchException;
	public CrewMember getCrewByBp(CrewMember crewMember) throws BatchException;
	
	
}
