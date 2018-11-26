package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Type Response detail GCP
 * @author robregons
 */
public class DetailResponseGCP implements Serializable {

	private static final long serialVersionUID = -6198993257438457952L;
	
	//para obtener informaci�n del reporte de vuelo
	private String names;
	
	private String lastName;
	
	private String position;
	
	private String bp;
	
	private String nameTc;
	
	private String lastNameTc;
	
	private String operator;
	
	private String numFlight;
	
	private List<QuestionResponseType> questionsList = new ArrayList<>();
	
	private String strength;
	
	private String improvement;
	
	private String comments;
	
	private String firmJsb;
	
	private String firmTc;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getNameTc() {
		return nameTc;
	}

	public void setNameTc(String nameTc) {
		this.nameTc = nameTc;
	}

	public String getLastNameTc() {
		return lastNameTc;
	}

	public void setLastNameTc(String lastNameTc) {
		this.lastNameTc = lastNameTc;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNumFlight() {
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public List<QuestionResponseType> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<QuestionResponseType> questionsList) {
		this.questionsList = questionsList;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFirmJsb() {
		return firmJsb;
	}

	public void setFirmJsb(String firmJsb) {
		this.firmJsb = firmJsb;
	}

	public String getFirmTc() {
		return firmTc;
	}

	public void setFirmTc(String firmTc) {
		this.firmTc = firmTc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bp == null) ? 0 : bp.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((firmJsb == null) ? 0 : firmJsb.hashCode());
		result = prime * result + ((firmTc == null) ? 0 : firmTc.hashCode());
		result = prime * result
				+ ((improvement == null) ? 0 : improvement.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((lastNameTc == null) ? 0 : lastNameTc.hashCode());
		result = prime * result + ((nameTc == null) ? 0 : nameTc.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result
				+ ((numFlight == null) ? 0 : numFlight.hashCode());
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result
				+ ((questionsList == null) ? 0 : questionsList.hashCode());
		result = prime * result
				+ ((strength == null) ? 0 : strength.hashCode());
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
		DetailResponseGCP other = (DetailResponseGCP) obj;
		if (bp == null) {
			if (other.bp != null)
				return false;
		} else if (!bp.equals(other.bp))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (firmJsb == null) {
			if (other.firmJsb != null)
				return false;
		} else if (!firmJsb.equals(other.firmJsb))
			return false;
		if (firmTc == null) {
			if (other.firmTc != null)
				return false;
		} else if (!firmTc.equals(other.firmTc))
			return false;
		if (improvement == null) {
			if (other.improvement != null)
				return false;
		} else if (!improvement.equals(other.improvement))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastNameTc == null) {
			if (other.lastNameTc != null)
				return false;
		} else if (!lastNameTc.equals(other.lastNameTc))
			return false;
		if (nameTc == null) {
			if (other.nameTc != null)
				return false;
		} else if (!nameTc.equals(other.nameTc))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (numFlight == null) {
			if (other.numFlight != null)
				return false;
		} else if (!numFlight.equals(other.numFlight))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (questionsList == null) {
			if (other.questionsList != null)
				return false;
		} else if (!questionsList.equals(other.questionsList))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetailResponseGCP [names=" + names + ", lastName=" + lastName
				+ ", position=" + position + ", bp=" + bp + ", nameTc="
				+ nameTc + ", lastNameTc=" + lastNameTc + ", operator="
				+ operator + ", numFlight=" + numFlight + ", questionsList="
				+ questionsList + ", strength=" + strength + ", improvement="
				+ improvement + ", comments=" + comments
				+ ", firmJsb=" + firmJsb + ", firmTc=" + firmTc
				+ "]";
	}
	

}
