package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;


public class ActivityLeg implements Serializable {

	private static final long serialVersionUID = -8231203950003662030L;

	private long id;

	private Flight flight;

	private Airport departureAirport;

	private CrewMember onBoardServiceChiefBP;

	private Date scheduleDepartureDate;

	private Airport arrivalAirport;

	private Date departureLocalDate;

	private Date arrivalLocalDate;

	private Date departureUTCDate;

	private Date arrivalUTCDate;

	private String tailNumber;

	private String equipment;

	private String materialType;

	public ActivityLeg() {

		departureAirport = new Airport();

		arrivalAirport = new Airport();

		flight = new Flight();

		onBoardServiceChiefBP = new CrewMember();
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public CrewMember getOnBoardServiceChiefBP() {
		return onBoardServiceChiefBP;
	}

	public void setOnBoardServiceChiefBP(CrewMember onBoardServiceChiefBP) {
		this.onBoardServiceChiefBP = onBoardServiceChiefBP;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getScheduleDepartureDate() {
		return scheduleDepartureDate;
	}

	public void setScheduleDepartureDate(Date scheduleDepartureDate) {
		this.scheduleDepartureDate = scheduleDepartureDate;
	}

	public Date getDepartureLocalDate() {
		return departureLocalDate;
	}

	public void setDepartureLocalDate(Date departureLocalDate) {
		this.departureLocalDate = departureLocalDate;
	}

	public Date getArrivalLocalDate() {
		return arrivalLocalDate;
	}

	public void setArrivalLocalDate(Date arrivalLocalDate) {
		this.arrivalLocalDate = arrivalLocalDate;
	}

	public Date getDepartureUTCDate() {
		return departureUTCDate;
	}

	public void setDepartureUTCDate(Date departureUTCDate) {
		this.departureUTCDate = departureUTCDate;
	}

	public Date getArrivalUTCDate() {
		return arrivalUTCDate;
	}

	public void setArrivalUTCDate(Date arrivalUTCDate) {
		this.arrivalUTCDate = arrivalUTCDate;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((arrivalLocalDate == null) ? 0 : arrivalLocalDate.hashCode());
		result = prime * result + ((arrivalUTCDate == null) ? 0 : arrivalUTCDate.hashCode());
		result = prime * result + ((departureAirport == null) ? 0 : departureAirport.hashCode());
		result = prime * result + ((departureLocalDate == null) ? 0 : departureLocalDate.hashCode());
		result = prime * result + ((departureUTCDate == null) ? 0 : departureUTCDate.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((materialType == null) ? 0 : materialType.hashCode());
		result = prime * result + ((onBoardServiceChiefBP == null) ? 0 : onBoardServiceChiefBP.hashCode());
		result = prime * result + ((scheduleDepartureDate == null) ? 0 : scheduleDepartureDate.hashCode());
		result = prime * result + ((tailNumber == null) ? 0 : tailNumber.hashCode());
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
		ActivityLeg other = (ActivityLeg) obj;
		if (arrivalAirport == null) {
			if (other.arrivalAirport != null)
				return false;
		} else if (!arrivalAirport.equals(other.arrivalAirport))
			return false;
		if (arrivalLocalDate == null) {
			if (other.arrivalLocalDate != null)
				return false;
		} else if (!arrivalLocalDate.equals(other.arrivalLocalDate))
			return false;
		if (arrivalUTCDate == null) {
			if (other.arrivalUTCDate != null)
				return false;
		} else if (!arrivalUTCDate.equals(other.arrivalUTCDate))
			return false;
		if (departureAirport == null) {
			if (other.departureAirport != null)
				return false;
		} else if (!departureAirport.equals(other.departureAirport))
			return false;
		if (departureLocalDate == null) {
			if (other.departureLocalDate != null)
				return false;
		} else if (!departureLocalDate.equals(other.departureLocalDate))
			return false;
		if (departureUTCDate == null) {
			if (other.departureUTCDate != null)
				return false;
		} else if (!departureUTCDate.equals(other.departureUTCDate))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (id != other.id)
			return false;
		if (materialType == null) {
			if (other.materialType != null)
				return false;
		} else if (!materialType.equals(other.materialType))
			return false;
		if (onBoardServiceChiefBP == null) {
			if (other.onBoardServiceChiefBP != null)
				return false;
		} else if (!onBoardServiceChiefBP.equals(other.onBoardServiceChiefBP))
			return false;
		if (scheduleDepartureDate == null) {
			if (other.scheduleDepartureDate != null)
				return false;
		} else if (!scheduleDepartureDate.equals(other.scheduleDepartureDate))
			return false;
		if (tailNumber == null) {
			if (other.tailNumber != null)
				return false;
		} else if (!tailNumber.equals(other.tailNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActivityLeg [id=" + id + ", flight=" + flight + ", departureAirport=" + departureAirport + ", onBoardServiceChiefBP="
				+ onBoardServiceChiefBP + ", scheduleDepartureDate=" + scheduleDepartureDate + ", arrivalAirport=" + arrivalAirport
				+ ", departureLocalDate=" + departureLocalDate + ", arrivalLocalDate=" + arrivalLocalDate + ", departureUTCDate="
				+ departureUTCDate + ", arrivalUTCDate=" + arrivalUTCDate + ", tailNumber=" + tailNumber + ", equipment=" + equipment
				+ ", materialType=" + materialType + "]";
	}

}
