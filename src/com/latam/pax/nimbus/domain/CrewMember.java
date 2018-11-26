package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author TCS 
 * @author j.isequilla@tcs.com
 * 
 * Clase que representa al tripulante 
 *
 */

@XmlRootElement(name = "crewMember")
public class CrewMember implements Serializable{

	private static final long serialVersionUID = -6628758431376870064L;

	private String bp;
	
	private String firstName;
	
	private String lastName;

	
	private Date creationDate;

	private String operator;
	
	private Date lastSyncDate;
	
	private String headQuarters;
	
	private String activeRank;

	private String specialRank;

	
	public String getActiveRank() {
		return activeRank;
	}

	public void setActiveRank(String activeRank) {
		this.activeRank = activeRank;
	}

	public String getSpecialRank() {
		return specialRank;
	}

	public void setSpecialRank(String specialRank) {
		this.specialRank = specialRank;
	}

	public CrewMember(){
		
	}
	
	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getLastSyncDate() {
		return lastSyncDate;
	}

	public void setLastSyncDate(Date lastSyncDate) {
		this.lastSyncDate = lastSyncDate;
	}

	public String getHeadQuarters() {
		return headQuarters;
	}

	public void setHeadQuarters(String headQuarters) {
		this.headQuarters = headQuarters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeRank == null) ? 0 : activeRank.hashCode());
		result = prime * result + ((bp == null) ? 0 : bp.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((headQuarters == null) ? 0 : headQuarters.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((lastSyncDate == null) ? 0 : lastSyncDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result
				+ ((specialRank == null) ? 0 : specialRank.hashCode());
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
		CrewMember other = (CrewMember) obj;
		if (activeRank == null) {
			if (other.activeRank != null)
				return false;
		} else if (!activeRank.equals(other.activeRank))
			return false;
		if (bp == null) {
			if (other.bp != null)
				return false;
		} else if (!bp.equals(other.bp))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (headQuarters == null) {
			if (other.headQuarters != null)
				return false;
		} else if (!headQuarters.equals(other.headQuarters))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastSyncDate == null) {
			if (other.lastSyncDate != null)
				return false;
		} else if (!lastSyncDate.equals(other.lastSyncDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (specialRank == null) {
			if (other.specialRank != null)
				return false;
		} else if (!specialRank.equals(other.specialRank))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "CrewMember [bp=" + bp + ", firstName=" + firstName + ", lastName="
				+ lastName + ", creationDate=" + creationDate + ", operator="
				+ operator + ", lastSyncDate=" + lastSyncDate
				+ ", headQuarters=" + headQuarters + ", activeRank="
				+ activeRank + ", specialRank=" + specialRank + "]";
	}
	

}
