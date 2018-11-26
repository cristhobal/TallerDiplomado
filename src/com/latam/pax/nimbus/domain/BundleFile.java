package com.latam.pax.nimbus.domain;

import java.io.Serializable;
/**
 * @author Manuel
 * @version 1.0
 * @created 18-may.-2017 16:43:01
 */
public class BundleFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bundle;
	private String business;
	private String cabin;

	private String userName;
	private BundleDates bundleDates;
	
	public BundleDates getBundleDates() {
		return bundleDates;
	}
	public void setBundleDates(BundleDates bundleDates) {
		this.bundleDates = bundleDates;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBundle() {
		return bundle;
	}
	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((null == userName) ? 0 : userName.hashCode());
		result = prime * result + ((null == bundle) ? 0 : bundle.hashCode());
		result = prime * result + ((null == business) ? 0 : business.hashCode());
		result = prime * result + ((null == cabin) ? 0 : cabin.hashCode());
		
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
		BundleFile other = (BundleFile) obj;
		if (null == bundle) {
			if (null != other.bundle)
				return false;
		} else if (!bundle.equals(other.bundle))
			return false;
		return validateEquals(other);
	}
	
	private boolean validateEquals(BundleFile other) {
		if (null == business) {
			if (null != other.business)
				return false;
		} else if (!business.equals(other.business))
			return false;
		if (null == cabin) {
			if (null != other.cabin)
				return false;
		} else if (!cabin.equals(other.cabin))
			return false;
		if (null == userName) {
			if (null !=other.userName)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BundleFile [bundle=" + bundle + ", business=" + business + ", cabin="
				+ cabin + ", userName=" + userName +  "]";
	}

	
	

}