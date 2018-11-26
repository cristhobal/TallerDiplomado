
package com.latam.pax.nimbus.domain;


import java.io.Serializable;
/**
 * @author Manuel
 * @version 1.0
 * @created 18-may.-2017 16:43:02
 */
public class BusinessFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String businessName;
	private String dateEdition;
	private String elementName;
	private String region;
	private String userName;
	
	public String getDateEdition() {
		return dateEdition;
	}
	public void setDateEdition(String dateEdition) {
		this.dateEdition = dateEdition;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusinessFile other = (BusinessFile) obj;
		if (null == businessName) {
			if (null != other.businessName)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (null == dateEdition) {
			if (null != other.dateEdition)
				return false;
		} else if (!dateEdition.equals(other.dateEdition))
			return false;
		return validateEquals(other);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((null == businessName) ? 0 : businessName.hashCode());
		result = prime * result + ((null == dateEdition) ? 0 : dateEdition.hashCode());
		result = prime * result + ((null == elementName) ? 0 : elementName.hashCode());
		result = prime * result + ((null == region) ? 0 : region.hashCode());
		result = prime * result + ((null == userName) ? 0 : userName.hashCode());
		return result;
	}
	
	private boolean validateEquals(BusinessFile other) {
		if (null == elementName) {
			if (null != other.elementName)
				return false;
		} else if (!elementName.equals(other.elementName))
			return false;
		if (null == region) {
			if (null != other.region)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (null == userName) {
			if (null != other.userName)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BusinessFile [businessName=" + businessName + ", dateEdition=" + dateEdition + ", elementName="
				+ elementName + ", region=" + region + ", userName="
				+ userName + "]";
	}

}