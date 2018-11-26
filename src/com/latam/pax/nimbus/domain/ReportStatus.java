package com.latam.pax.nimbus.domain;

import java.io.Serializable;


/**
 * 
 * Class for Managing report status: - Waiting Attachment - Waiting report - OK
 * - ERROR
 * 
 * @author TCS
 * @author j.isequilla@tcs.com (Jeremias de Isequilla)
 * 
 */
public class ReportStatus implements Serializable {

	private static final long serialVersionUID = 3653849860849839505L;

	private String code;

	private String description;

	public ReportStatus(){
		
	}
	
	public ReportStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		ReportStatus other = (ReportStatus) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReportStatus [code=" + code + ", description=" + description + "]";
	}

}
