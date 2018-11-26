package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.List;

import com.latam.pax.nimbus.domain.CrewMember;

public class GcpEvaluationsReports implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ResultGCP4JSB> gcpList;
	private CrewMember appraiser;
	private int numEvaluations;


	public List<ResultGCP4JSB> getGcpList() {
		return gcpList;
	}

	public void setGcpList(List<ResultGCP4JSB> gcpList) {
		this.gcpList = gcpList;
	}

	public CrewMember getAppraiser() {
		return appraiser;
	}

	public void setAppraiser(CrewMember appraiser) {
		this.appraiser = appraiser;
	}

	public int getNumEvaluations() {
		return numEvaluations;
	}

	public void setNumEvaluations(int numEvaluations) {
		this.numEvaluations = numEvaluations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appraiser == null) ? 0 : appraiser.hashCode());
		result = prime * result + ((gcpList == null) ? 0 : gcpList.hashCode());
		result = prime * result + numEvaluations;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GcpEvaluationsReports other = (GcpEvaluationsReports) obj;
		if (appraiser == null) {
			if (other.appraiser != null)
				return false;
		} else if (!appraiser.equals(other.appraiser))
			return false;
		if (gcpList == null) {
			if (other.gcpList != null)
				return false;
		} else if (!gcpList.equals(other.gcpList))
			return false;
		if (numEvaluations != other.numEvaluations)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GcpEvaluationsReports [gcpList=" + gcpList + ", appraiser="
				+ appraiser + ", numEvaluations=" + numEvaluations + "]";
	}


	
	
}
