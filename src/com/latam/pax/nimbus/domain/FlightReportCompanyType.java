package com.latam.pax.nimbus.domain;

import java.io.Serializable;

public class FlightReportCompanyType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String description;
	private String codeCompany;
	private Integer versionReleased;
	private Integer versionCurrent;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeCompany() {
		return codeCompany;
	}

	public void setCodeCompany(String codeCompany) {
		this.codeCompany = codeCompany;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersionReleased() {
		return versionReleased;
	}

	public void setVersionReleased(Integer versionReleased) {
		this.versionReleased = versionReleased;
	}

	public Integer getVersionCurrent() {
		return versionCurrent;
	}

	public void setVersionCurrent(Integer versionCurrent) {
		this.versionCurrent = versionCurrent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((codeCompany == null) ? 0 : codeCompany.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((versionCurrent == null) ? 0 : versionCurrent.hashCode());
		result = prime * result + ((versionReleased == null) ? 0 : versionReleased.hashCode());
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
		FlightReportCompanyType other = (FlightReportCompanyType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeCompany == null) {
			if (other.codeCompany != null)
				return false;
		} else if (!codeCompany.equals(other.codeCompany))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (versionCurrent == null) {
			if (other.versionCurrent != null)
				return false;
		} else if (!versionCurrent.equals(other.versionCurrent))
			return false;
		if (versionReleased == null) {
			if (other.versionReleased != null)
				return false;
		} else if (!versionReleased.equals(other.versionReleased))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightReportCompanyType [code=" + code + ", description=" + description + ", codeCompany=" + codeCompany
				+ ", versionReleased=" + versionReleased + ", versionCurrent=" + versionCurrent + "]";
	}

}
