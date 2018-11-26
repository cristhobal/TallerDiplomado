package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;


import com.latam.pax.nimbus.domain.Flight;
import com.latam.pax.nimbus.domain.ReportStatus;

public class ResultGCP4JSBBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tabletCode;

	private ReportStatus status;

	private String errorMsg;

	private Date creationDate;

	private Date flightDate;

	private Date expirationDate;

	private Flight flight;
	
	private String strengths;
	
	private String improvements;

	

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getImprovements() {
		return improvements;
	}

	public void setImprovements(String improvements) {
		this.improvements = improvements;
	}

	public String getTabletCode() {
		return tabletCode;
	}

	public void setTabletCode(String tabletCode) {
		this.tabletCode = tabletCode;
	}

	public ReportStatus getStatus() {
		return status;
	}

	public void setStatus(ReportStatus status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result
				+ ((flightDate == null) ? 0 : flightDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((tabletCode == null) ? 0 : tabletCode.hashCode());
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
		ResultGCP4JSBBase other = (ResultGCP4JSBBase) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (errorMsg == null) {
			if (other.errorMsg != null)
				return false;
		} else if (!errorMsg.equals(other.errorMsg))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (flightDate == null) {
			if (other.flightDate != null)
				return false;
		} else if (!flightDate.equals(other.flightDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tabletCode == null) {
			if (other.tabletCode != null)
				return false;
		} else if (!tabletCode.equals(other.tabletCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultGCP4JSBBase [tabletCode=" + tabletCode + ", status="
				+ status + ", errorMsg=" + errorMsg + ", creationDate="
				+ creationDate + ", flightDate=" + flightDate
				+ ", expirationDate=" + expirationDate + ", flight=" + flight
				+ "]";
	}
	
	
	

}
