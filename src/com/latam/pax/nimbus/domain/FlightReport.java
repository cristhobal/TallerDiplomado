package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;


public class FlightReport implements Serializable {

	private static final long serialVersionUID = 3426594489032060017L;

	private long cdg; // "INFVLO_SEQ_CDG" NUMBER(19,0) NOT NULL ENABLE,
	private String equipmentTypeCdg; // "TIPINF_CDG" VARCHAR2(2 BYTE),
	private String companyCdg; // "TIPOIV_CDG_CIA" VARCHAR2(3 BYTE) NOT NULL
								// ENABLE,

	private Date creationDate; // "INFVLO_FCH_REG" DATE NOT NULL ENABLE
	private String version;
	private String cdgIVTablet; // "INFVLO_CDG_TABLET" VARCHAR2(10 BYTE) NOT
								// NULL ENABLE,
	private Date expirationDate; // ("INFVLO_FCH_EXPIRA_EDO" DATE,
	private String infvloMens; // "INFVLO_MENS" VARCHAR2(50 BYTE),
	private String edorptCdg; // "EDORPT_CDG" VARCHAR2(2 BYTE)
	private String active;  // INFVLO_ACTIVO

	private Long id;
	private String tabletCode;
	private String messageError;
	private ReportStatus reportStatus;
	private FlightReportCompanyType flightReportCompanyType;

	public FlightReport() {

	}
	
	@Override
	public String toString() {
		return "FlightReport [cdg=" + cdg + ", equipmentTypeCdg="
				+ equipmentTypeCdg + ", companyCdg=" + companyCdg
				+ ", creationDate=" + creationDate + ", version=" + version
				+ ", cdgIVTablet=" + cdgIVTablet + ", expirationDate="
				+ expirationDate + ", infvloMens=" + infvloMens
				+ ", edorptCdg=" + edorptCdg + ", active=" + active
				+ ", id=" + id + ", tabletCode=" + tabletCode
				+ ", messageError=" + messageError + ", reportStatus="
				+ reportStatus + ", flightReportCompanyType="
				+ flightReportCompanyType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdg ^ (cdg >>> 32));
		result = prime * result
				+ ((cdgIVTablet == null) ? 0 : cdgIVTablet.hashCode());
		result = prime * result
				+ ((companyCdg == null) ? 0 : companyCdg.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((edorptCdg == null) ? 0 : edorptCdg.hashCode());
		result = prime
				* result
				+ ((equipmentTypeCdg == null) ? 0 : equipmentTypeCdg.hashCode());
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime
				* result
				+ ((flightReportCompanyType == null) ? 0
						: flightReportCompanyType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((infvloMens == null) ? 0 : infvloMens.hashCode());
		result = prime * result
				+ ((messageError == null) ? 0 : messageError.hashCode());
		result = prime * result
				+ ((reportStatus == null) ? 0 : reportStatus.hashCode());
		result = prime * result
				+ ((tabletCode == null) ? 0 : tabletCode.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		FlightReport other = (FlightReport) obj;
		if (cdg != other.cdg)
			return false;
		if (cdgIVTablet == null) {
			if (other.cdgIVTablet != null)
				return false;
		} else if (!cdgIVTablet.equals(other.cdgIVTablet))
			return false;
		if (companyCdg == null) {
			if (other.companyCdg != null)
				return false;
		} else if (!companyCdg.equals(other.companyCdg))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (edorptCdg == null) {
			if (other.edorptCdg != null)
				return false;
		} else if (!edorptCdg.equals(other.edorptCdg))
			return false;
		if (equipmentTypeCdg == null) {
			if (other.equipmentTypeCdg != null)
				return false;
		} else if (!equipmentTypeCdg.equals(other.equipmentTypeCdg))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (flightReportCompanyType == null) {
			if (other.flightReportCompanyType != null)
				return false;
		} else if (!flightReportCompanyType
				.equals(other.flightReportCompanyType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infvloMens == null) {
			if (other.infvloMens != null)
				return false;
		} else if (!infvloMens.equals(other.infvloMens))
			return false;
		if (messageError == null) {
			if (other.messageError != null)
				return false;
		} else if (!messageError.equals(other.messageError))
			return false;
		if (reportStatus == null) {
			if (other.reportStatus != null)
				return false;
		} else if (!reportStatus.equals(other.reportStatus))
			return false;
		if (tabletCode == null) {
			if (other.tabletCode != null)
				return false;
		} else if (!tabletCode.equals(other.tabletCode))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}


	public long getCdg() {
		return cdg;
	}
	

	public void setCdg(long cdg) {
		this.cdg = cdg;
	}

	
	public String getEquipmentTypeCdg() {
		return equipmentTypeCdg;
	}

	public void setEquipmentTypeCdg(String equipmentTypeCdg) {
		this.equipmentTypeCdg = equipmentTypeCdg;
	}

	
	public String getCompanyCdg() {
		return companyCdg;
	}

	
	public void setCompanyCdg(String companyCdg) {
		this.companyCdg = companyCdg;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	public String getCdgIVTablet() {
		return cdgIVTablet;
	}

	public void setCdgIVTablet(String cdgIVTablet) {
		this.cdgIVTablet = cdgIVTablet;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	
	public String getInfvloMens() {
		return infvloMens;
	}

	public void setInfvloMens(String infvloMens) {
		this.infvloMens = infvloMens;
	}

	
	public String getEdorptCdg() {
		return edorptCdg;
	}

	public void setEdorptCdg(String edorptCdg) {
		this.edorptCdg = edorptCdg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTabletCode() {
		return tabletCode;
	}

	public void setTabletCode(String tabletCode) {
		this.tabletCode = tabletCode;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public ReportStatus getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(ReportStatus reportStatus) {
		this.reportStatus = reportStatus;
	}

	public FlightReportCompanyType getFlightReportCompanyType() {
		return flightReportCompanyType;
	}

	public void setFlightReportCompanyType(FlightReportCompanyType flightReportCompanyType) {
		this.flightReportCompanyType = flightReportCompanyType;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
