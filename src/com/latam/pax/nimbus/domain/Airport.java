package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author TCS
 * @author j.isequilla@tcs.com
 * 
 *         Clase Aeropuerto, representa los aeropuertos habilitados para el
 *         negocio de HGSAB, donde opera LAN/TAM
 */
public class Airport implements Serializable {

	private static final long serialVersionUID = 5516408228143686233L;

	private String iataCode;
	
	private Date createDate;

	
	public Airport() {
		
	}
	
	public Airport(String iataCode) {
		this.iataCode = iataCode;
		this.createDate = new Date();
	}
	
	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	@Override
	public String toString() {
		return "Airport [iataCode=" + iataCode + ", createDate=" + createDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((iataCode == null) ? 0 : iataCode.hashCode());
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
		Airport other = (Airport) obj;
		if (iataCode == null) {
			if (other.iataCode != null)
				return false;
		} else if (!iataCode.equals(other.iataCode))
			return false;
		return true;
	}
	
}
