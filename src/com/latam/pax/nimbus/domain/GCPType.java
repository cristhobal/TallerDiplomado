/**
 * 
 */
package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Class that maintains a GAD Type information
 * 
 * @author TCS
 * @author j.isequilla@tcs.com (Jeremias de Isequilla)
 * 
 */
public class GCPType implements Serializable {

	private static final long serialVersionUID = -1302106684616849786L;

	private int code;

	private MaterialType materialType;

	private String companyCode;

	private String description;

	private Date creationDate;

	private Date updatedDate;

	private String typeGadDescription;

	public String getTypeGadDescription() {
		return typeGadDescription;
	}

	public void setTypeGadDescription(String typeGadDescription) {
		this.typeGadDescription = typeGadDescription;
	}
	
	/**
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            creationDate por asignar
	 */
	public void setCreationDate(Date fchCreacion) {
		this.creationDate = fchCreacion;
	}

	/**
	 * @return updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            updatedDate por asignar
	 */
	public void setUpdatedDate(Date fchActualizacion) {
		this.updatedDate = fchActualizacion;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
		result = prime * result + code;
		result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((materialType == null) ? 0 : materialType.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		GCPType other = (GCPType) obj;
		if (code != other.code)
			return false;
		if (companyCode == null) {
			if (other.companyCode != null)
				return false;
		} else if (!companyCode.equals(other.companyCode))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (materialType == null) {
			if (other.materialType != null)
				return false;
		} else if (!materialType.equals(other.materialType))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GCPType [code=" + code + ", materialType=" + materialType + ", companyCode=" + companyCode + ", description=" + description
				+ ", creationDate=" + creationDate + ", updatedDate=" + updatedDate + "]";
	}

}
