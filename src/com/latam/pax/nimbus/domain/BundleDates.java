package com.latam.pax.nimbus.domain;

import java.io.Serializable;

/**
 * 
 * @author Manuel
 *
 */
public class BundleDates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String editionDate;
	private String validityEndDate;
	private String validityInitDate;
	private String classType;
	
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classTyoe) {
		this.classType = classTyoe;
	}
	public String getValidityInitDate() {
		return validityInitDate;
	}
	public void setValidityInitDate(String validityInitDate) {
		this.validityInitDate = validityInitDate;
	}

	public String getValidityEndDate() {
		return validityEndDate;
	}
	public void setValidityEndDate(String validityEndDate) {
		this.validityEndDate = validityEndDate;
	}
	public String getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(String editionDate) {
		this.editionDate = editionDate;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((null == validityEndDate) ? 0 : validityEndDate.hashCode());
		result = prime * result + ((null == validityInitDate) ? 0 : validityInitDate.hashCode());
		result = prime * result + ((null == editionDate) ? 0 : editionDate.hashCode());
		result = prime * result + ((null == classType) ? 0 : classType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BundleDates other = (BundleDates) obj;
		if (null == editionDate) {
			if (null != other.editionDate)
				return false;
		} else if (!editionDate.equals(other.editionDate))
			return false;
		return validateEquals(other);
	}
	private boolean validateEquals(BundleDates other) {
		if (null == validityEndDate) {
			if (null != other.validityEndDate)
				return false;
		} else if (!validityEndDate.equals(other.validityEndDate))
			return false;
		if (null == validityInitDate) {
			if (null != other.validityInitDate)
				return false;
		} else if (!validityInitDate.equals(other.validityInitDate))
			return false;
		if (null == classType) {
			if (null != other.classType)
				return false;
		} else if (!classType.equals(other.classType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BundleDates [editionDate=" + editionDate + ", validityEndDate=" + validityEndDate + ", validityInitDate="
				+ validityInitDate +", classType=" + classType+ "]";
	}
	
	
}
