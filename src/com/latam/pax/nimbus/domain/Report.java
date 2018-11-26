package com.latam.pax.nimbus.domain;

import java.io.Serializable;

/**
 * 
 * @author Robregons
 *
 */
public class Report implements Serializable {
	
	private static final long serialVersionUID = 625446132340553538L;
	
	private String reportId;
	private String operator;
	private String fligthCode;
	private String fligthDate;
	private String airportOriginCode;
	private String airportDestinationCode;
	private String jsbName;
	private String jsbBp;
	private String mail;
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getJsbBp() {
		return jsbBp;
	}
	public void setJsbBp(String jsbBp) {
		this.jsbBp = jsbBp;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getFligthCode() {
		return fligthCode;
	}
	public void setFligthCode(String fligthCode) {
		this.fligthCode = fligthCode;
	}
	public String getFligthDate() {
		return fligthDate;
	}
	public void setFligthDate(String fligthDate) {
		this.fligthDate = fligthDate;
	}
	public String getAirportOriginCode() {
		return airportOriginCode;
	}
	public void setAirportOriginCode(String airportOriginCode) {
		this.airportOriginCode = airportOriginCode;
	}
	public String getAirportDestinationCode() {
		return airportDestinationCode;
	}
	public void setAirportDestinationCode(String airportDestinationCode) {
		this.airportDestinationCode = airportDestinationCode;
	}
	public String getJsbName() {
		return jsbName;
	}
	public void setJsbName(String jsbName) {
		this.jsbName = jsbName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportDestinationCode == null) ? 0 : airportDestinationCode.hashCode());
		result = prime * result + ((airportOriginCode == null) ? 0 : airportOriginCode.hashCode());
		result = prime * result + ((fligthCode == null) ? 0 : fligthCode.hashCode());
		result = prime * result + ((fligthDate == null) ? 0 : fligthDate.hashCode());
		result = prime * result + ((jsbBp == null) ? 0 : jsbBp.hashCode());
		result = prime * result + ((jsbName == null) ? 0 : jsbName.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((reportId == null) ? 0 : reportId.hashCode());
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
		Report other = (Report) obj;
		if (airportDestinationCode == null) {
			if (other.airportDestinationCode != null)
				return false;
		} else if (!airportDestinationCode.equals(other.airportDestinationCode))
			return false;
		if (airportOriginCode == null) {
			if (other.airportOriginCode != null)
				return false;
		} else if (!airportOriginCode.equals(other.airportOriginCode))
			return false;
		if (fligthCode == null) {
			if (other.fligthCode != null)
				return false;
		} else if (!fligthCode.equals(other.fligthCode))
			return false;
		if (fligthDate == null) {
			if (other.fligthDate != null)
				return false;
		} else if (!fligthDate.equals(other.fligthDate))
			return false;
		if (jsbBp == null) {
			if (other.jsbBp != null)
				return false;
		} else if (!jsbBp.equals(other.jsbBp))
			return false;
		if (jsbName == null) {
			if (other.jsbName != null)
				return false;
		} else if (!jsbName.equals(other.jsbName))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (reportId == null) {
			if (other.reportId != null)
				return false;
		} else if (!reportId.equals(other.reportId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", operator=" + operator + ", fligthCode=" + fligthCode
				+ ", fligthDate=" + fligthDate + ", airportOriginCode=" + airportOriginCode
				+ ", airportDestinationCode=" + airportDestinationCode + ", jsbName=" + jsbName + ", jsbBp=" + jsbBp
				+ ", mail=" + mail + "]";
	}
	

}
