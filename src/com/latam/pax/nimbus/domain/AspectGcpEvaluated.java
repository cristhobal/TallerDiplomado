package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Map;


public class AspectGcpEvaluated implements Serializable {

	private static final long serialVersionUID = 1L;
	transient String codeGcp;
	private String codeTypeGcpd;
	private String codeAspect;
	private String aspect;
	private String aspectPT;
	private String average;
	private float averageTotal;
	private long quantity;
	private Map<String, String> property;
	private String section;
	private String phase;
	private String typeQuestion;
	private int codeSection;
	private int codePhase;
	
	public int getCodeSection() {
		return codeSection;
	}
	public void setCodeSection(int codeSection) {
		this.codeSection = codeSection;
	}
	public int getCodePhase() {
		return codePhase;
	}
	public void setCodePhase(int codePhase) {
		this.codePhase = codePhase;
	}
	public String getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getCodeGcd() {
		return codeGcp;
	}
	public void setCodeGcd(String codeGcd) {
		this.codeGcp = codeGcd;
	}
	public String getCodeTypeGcpd() {
		return codeTypeGcpd;
	}
	public void setCodeTypeGcpd(String codeTypeGcpd) {
		this.codeTypeGcpd = codeTypeGcpd;
	}
	public String getCodeAspect() {
		return codeAspect;
	}
	public void setCodeAspect(String codeAspect) {
		this.codeAspect = codeAspect;
	}
	public String getAspect() {
		return aspect;
	}
	public void setCodeGcp(String codeGcp) {
		this.codeGcp = codeGcp;
	}
	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
	public String getAspectPT() {
		return aspectPT;
	}
	public void setAspectPT(String aspectPT) {
		this.aspectPT = aspectPT;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public float getAverageTotal() {
		return averageTotal;
	}
	public void setAverageTotal(float averageTotal) {
		this.averageTotal = averageTotal;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Map<String, String> getProperty() {
		return property;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aspect == null) ? 0 : aspect.hashCode());
		result = prime * result
				+ ((aspectPT == null) ? 0 : aspectPT.hashCode());
		result = prime * result + ((average == null) ? 0 : average.hashCode());
		result = prime * result + Float.floatToIntBits(averageTotal);
		result = prime * result
				+ ((codeAspect == null) ? 0 : codeAspect.hashCode());
		result = prime * result + ((codeGcp == null) ? 0 : codeGcp.hashCode());
		result = prime * result
				+ ((codeTypeGcpd == null) ? 0 : codeTypeGcpd.hashCode());
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
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
		AspectGcpEvaluated other = (AspectGcpEvaluated) obj;
		if (aspect == null) {
			if (other.aspect != null)
				return false;
		} else if (!aspect.equals(other.aspect))
			return false;
		if (aspectPT == null) {
			if (other.aspectPT != null)
				return false;
		} else if (!aspectPT.equals(other.aspectPT))
			return false;
		if (average == null) {
			if (other.average != null)
				return false;
		} else if (!average.equals(other.average))
			return false;
		if (Float.floatToIntBits(averageTotal) != Float
				.floatToIntBits(other.averageTotal))
			return false;
		if (codeAspect == null) {
			if (other.codeAspect != null)
				return false;
		} else if (!codeAspect.equals(other.codeAspect))
			return false;
		if (codeGcp == null) {
			if (other.codeGcp != null)
				return false;
		} else if (!codeGcp.equals(other.codeGcp))
			return false;
		if (codeTypeGcpd == null) {
			if (other.codeTypeGcpd != null)
				return false;
		} else if (!codeTypeGcpd.equals(other.codeTypeGcpd))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AspectGcpEvaluated [codeGcd=" + codeGcp + ", codeTypeGcpd="
				+ codeTypeGcpd + ", codeAspect=" + codeAspect + ", aspect="
				+ aspect + ", aspectPT=" + aspectPT + ", average=" + average
				+ ", averageTotal=" + averageTotal + ", quantity=" + quantity
				+ ", property=" + property + "]";
	}
	public void setProperty(Map<String, String> property) {
		this.property = property;
	}

	
	
}