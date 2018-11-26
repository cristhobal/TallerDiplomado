package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.latam.pax.nimbus.business.GenerateReport;
import com.latam.pax.nimbus.domain.CrewMember;
import com.latam.pax.nimbus.domain.Document;
import com.latam.pax.nimbus.domain.GCPType;

public class ResultGCP4JSB extends ResultGCP4JSBBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String airlineCode;
	
	private CrewMember appraisee;

	private CrewMember appraiser;

	private Document appraiseeFile;

	private Document reviewerFile;

	private String reviewerComments;

	private String appraiseeComments;

	private GCPType type;

	private List<AspectGcpEvaluated> assessments;
	
	private static final Logger logger = Logger.getLogger(GenerateReport.class);

	public void addAssessments(AspectGcpEvaluated assessment) {
		if (this.assessments == null) {
			this.assessments = new ArrayList<AspectGcpEvaluated>();
		}
		this.assessments.add(assessment);
	}

	public CrewMember getAppraisee() {
		return appraisee;
	}

	public void setAppraisee(CrewMember appraisee) {
		this.appraisee = appraisee;
	}

	public Document getAppraiseeFile() {
		return appraiseeFile;
	}

	public void setAppraiseeFile(Document appraiseeFile) {
		this.appraiseeFile = appraiseeFile;
	}

	public Document getReviewerFile() {
		return reviewerFile;
	}

	public void setReviewerFile(Document reviewerFile) {
		this.reviewerFile = reviewerFile;
	}

	public String getReviewerComments() {
		return reviewerComments;
	}

	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAppraiseeComments() {
		return appraiseeComments;
	}

	public void setAppraiseeComments(String appraiseeComments) {
		this.appraiseeComments = appraiseeComments;
	}

	public GCPType getType() {
		return type;
	}

	public void setType(GCPType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AspectGcpEvaluated> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<AspectGcpEvaluated> assessments) {
		this.assessments = assessments;
	}

	public CrewMember getAppraiser() {
		return appraiser;
	}

	public void setAppraiser(CrewMember appraiser) {
		this.appraiser = appraiser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((appraisee == null) ? 0 : appraisee.hashCode());
		result = prime
				* result
				+ ((appraiseeComments == null) ? 0 : appraiseeComments
						.hashCode());
		result = prime * result
				+ ((appraiseeFile == null) ? 0 : appraiseeFile.hashCode());
		result = prime * result
				+ ((appraiser == null) ? 0 : appraiser.hashCode());
		result = prime * result
				+ ((assessments == null) ? 0 : assessments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((reviewerComments == null) ? 0 : reviewerComments.hashCode());
		result = prime * result
				+ ((reviewerFile == null) ? 0 : reviewerFile.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		try{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultGCP4JSB other = (ResultGCP4JSB) obj;
		if (appraisee == null) {
			if (other.appraisee != null)
				return false;
		} else if (!appraisee.equals(other.appraisee))
			return false;
		if (appraiseeComments == null) {
			if (other.appraiseeComments != null)
				return false;
		} else if (!appraiseeComments.equals(other.appraiseeComments))
			return false;
		if (appraiseeFile == null) {
			if (other.appraiseeFile != null)
				return false;
		} else if (!appraiseeFile.equals(other.appraiseeFile))
			return false;
		if (appraiser == null) {
			if (other.appraiser != null)
				return false;
		} else if (!appraiser.equals(other.appraiser))
			return false;
		if (assessments == null) {
			if (other.assessments != null)
				return false;
		} else if (!assessments.equals(other.assessments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reviewerComments == null) {
			if (other.reviewerComments != null)
				return false;
		} else if (!reviewerComments.equals(other.reviewerComments))
			return false;
		if (reviewerFile == null) {
			if (other.reviewerFile != null)
				return false;
		} else if (!reviewerFile.equals(other.reviewerFile))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		}catch(NullPointerException e){
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ResultGCP4JSB [id=" + id + ", appraisee=" + appraisee
				+ ", appraiser=" + appraiser + ", appraiseeFile="
				+ appraiseeFile + ", reviewerFile=" + reviewerFile
				+ ", reviewerComments=" + reviewerComments
				+ ", appraiseeComments=" + appraiseeComments + ", type=" + type
				+ ", assessments=" + assessments + "]";
	}
	
	

}
