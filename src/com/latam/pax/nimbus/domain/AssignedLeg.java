package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssignedLeg extends ActivityLeg implements Serializable {

	private static final long serialVersionUID = -8231203950003662030L;

	private String manualRegistration;

	private String legExecuted;

	private String businessCode;

	private String operator;

	private Date legCreationDate;

	private Date legUpdateDate;

	private List<CrewMember> crewMembers;

	private String materialType;

	private List<ServiceStatus> listServiceStatus;

	private FlightReport flightReport;

	private Date departureUTCDateOnly;
	
	private String active;

	public AssignedLeg() {

		super();

		flightReport = new FlightReport();

		listServiceStatus = new ArrayList<>();

		setCrewMembers(new ArrayList<CrewMember>());
	}

	public String getManualRegistration() {
		return manualRegistration;
	}

	public void setManualRegistration(String manualRegistration) {
		this.manualRegistration = manualRegistration;
	}

	public String getLegExecuted() {
		return legExecuted;
	}

	public void setLegExecuted(String legExecuted) {
		this.legExecuted = legExecuted;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getLegCreationDate() {
		return legCreationDate;
	}

	public void setLegCreationDate(Date legCreationDate) {
		this.legCreationDate = legCreationDate;
	}

	public Date getLegUpdateDate() {
		return legUpdateDate;
	}

	public void setLegUpdateDate(Date legUpdateDate) {
		this.legUpdateDate = legUpdateDate;
	}

	public List<CrewMember> getCrewMembers() {
		return crewMembers;
	}

	public void setCrewMembers(List<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}

	public void addCrewMember(CrewMember crewMember) {
		this.crewMembers.add(crewMember);
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
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

	public FlightReport getFlightReport() {
		return flightReport;
	}

	public void setFlightReport(FlightReport flightReport) {
		this.flightReport = flightReport;
	}

	public Date getDepartureUTCDateOnly() {
		return departureUTCDateOnly;
	}

	public void setDepartureUTCDateOnly(Date departureUTCDateOnly) {
		this.departureUTCDateOnly = departureUTCDateOnly;
	}


	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((businessCode == null) ? 0 : businessCode.hashCode());
		result = prime * result + ((crewMembers == null) ? 0 : crewMembers.hashCode());
		result = prime * result + ((departureUTCDateOnly == null) ? 0 : departureUTCDateOnly.hashCode());
		result = prime * result + ((flightReport == null) ? 0 : flightReport.hashCode());
		result = prime * result + ((legCreationDate == null) ? 0 : legCreationDate.hashCode());
		result = prime * result + ((legExecuted == null) ? 0 : legExecuted.hashCode());
		result = prime * result + ((legUpdateDate == null) ? 0 : legUpdateDate.hashCode());
		result = prime * result + ((listServiceStatus == null) ? 0 : listServiceStatus.hashCode());
		result = prime * result + ((manualRegistration == null) ? 0 : manualRegistration.hashCode());
		result = prime * result + ((materialType == null) ? 0 : materialType.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignedLeg other = (AssignedLeg) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (businessCode == null) {
			if (other.businessCode != null)
				return false;
		} else if (!businessCode.equals(other.businessCode))
			return false;
		if (crewMembers == null) {
			if (other.crewMembers != null)
				return false;
		} else if (!crewMembers.equals(other.crewMembers))
			return false;
		if (departureUTCDateOnly == null) {
			if (other.departureUTCDateOnly != null)
				return false;
		} else if (!departureUTCDateOnly.equals(other.departureUTCDateOnly))
			return false;
		if (flightReport == null) {
			if (other.flightReport != null)
				return false;
		} else if (!flightReport.equals(other.flightReport))
			return false;
		if (legCreationDate == null) {
			if (other.legCreationDate != null)
				return false;
		} else if (!legCreationDate.equals(other.legCreationDate))
			return false;
		if (legExecuted == null) {
			if (other.legExecuted != null)
				return false;
		} else if (!legExecuted.equals(other.legExecuted))
			return false;
		if (legUpdateDate == null) {
			if (other.legUpdateDate != null)
				return false;
		} else if (!legUpdateDate.equals(other.legUpdateDate))
			return false;
		if (listServiceStatus == null) {
			if (other.listServiceStatus != null)
				return false;
		} else if (!listServiceStatus.equals(other.listServiceStatus))
			return false;
		if (manualRegistration == null) {
			if (other.manualRegistration != null)
				return false;
		} else if (!manualRegistration.equals(other.manualRegistration))
			return false;
		if (materialType == null) {
			if (other.materialType != null)
				return false;
		} else if (!materialType.equals(other.materialType))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AssignedLeg [manualRegistration=" + manualRegistration + ", legExecuted=" + legExecuted + ", businessCode=" + businessCode
				+ ", operator=" + operator + ", legCreationDate=" + legCreationDate + ", legUpdateDate=" + legUpdateDate + ", crewMembers="
				+ crewMembers + ", materialType=" + materialType + ", listServiceStatus=" + listServiceStatus + ", flightReport="
				+ flightReport + ", departureUTCDateOnly=" + departureUTCDateOnly + ", active=" + active + ",ActivityLeg="+super.toString() +"]";
	}

}
