package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author TCS
 * @author j.isequilla@tcs.com
 * 
 *         Clase que repersenta un vuelo
 */
public class Flight implements Serializable {

	private static final long serialVersionUID = 5516408228143686233L;

	private String airlineCode;

	private Date flightDate;

	private String suffix;

	private int flightNumber;

	private Date createDate;

	private Date updateDate;

	private List<AssignedLeg> legs;

	private boolean inRange;

	private List<ServiceStatus> listServiceStatus;

	public Flight() {
		legs = new ArrayList<AssignedLeg>();
	}

	public Flight(String airlineCode, Date flightDate, String suffix, int flightNumber) {
		super();
		this.airlineCode = airlineCode;
		this.flightDate = flightDate;
		this.suffix = suffix;
		this.flightNumber = flightNumber;
		this.createDate = new Date();
		this.updateDate = new Date();
		legs = new ArrayList<AssignedLeg>();
		listServiceStatus = new ArrayList<ServiceStatus>();
	}

	public List<AssignedLeg> getLegs() {
		return legs;
	}

	public void setLegs(List<AssignedLeg> legs) {
		this.legs = legs;
	}

	public void addLegs(AssignedLeg leg) {
		legs.add(leg);
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isInRange() {
		return inRange;
	}

	public void setInRange(boolean inRange) {
		this.inRange = inRange;
	}

	public List<ServiceStatus> getListServiceStatus() {
		return listServiceStatus;
	}

	public void setListServiceStatus(List<ServiceStatus> listServiceStatus) {
		this.listServiceStatus = listServiceStatus;
	}

	public void addServiceStatus(ServiceStatus serviceStatus) {
		this.listServiceStatus.add(serviceStatus);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineCode == null) ? 0 : airlineCode.hashCode());
		result = prime * result + ((flightDate == null) ? 0 : flightDate.hashCode());
		result = prime * result + flightNumber;
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
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
		Flight other = (Flight) obj;
		if (airlineCode == null) {
			if (other.airlineCode != null)
				return false;
		} else if (!airlineCode.equals(other.airlineCode))
			return false;
		if (flightDate == null) {
			if (other.flightDate != null)
				return false;
		} else if (!flightDate.equals(other.flightDate))
			return false;
		if (flightNumber != other.flightNumber)
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [airlineCode=" + airlineCode + ", flightDate=" + flightDate + ", suffix=" + suffix + ", flightNumber="
				+ flightNumber + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
