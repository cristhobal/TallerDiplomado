package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "serviceStatus")
public class ServiceStatus implements Serializable {

	private static final long serialVersionUID = -4607523821389065642L;

	private int code;
	private String nativeMessage;
	private Map<String, String> mapLanguages;

	public Map<String, String> getMapLanguages() {
		return mapLanguages;
	}

	public void setMapLanguages(Map<String, String> mapLanguages) {
		this.mapLanguages = mapLanguages;
	}

	@XmlElement
	public String getNativeMessage() {
		return nativeMessage;
	}

	public void setNativeMessage(String nativeMessage) {
		this.nativeMessage = nativeMessage;
	}

	@XmlElement
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((mapLanguages == null) ? 0 : mapLanguages.hashCode());
		result = prime * result + ((nativeMessage == null) ? 0 : nativeMessage.hashCode());
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
		ServiceStatus other = (ServiceStatus) obj;
		if (code != other.code)
			return false;
		if (mapLanguages == null) {
			if (other.mapLanguages != null)
				return false;
		} else if (!mapLanguages.equals(other.mapLanguages))
			return false;
		if (nativeMessage == null) {
			if (other.nativeMessage != null)
				return false;
		} else if (!nativeMessage.equals(other.nativeMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceStatus [code=" + code + ", nativeMessage=" + nativeMessage + ", mapLanguages=" + mapLanguages + "]";
	}

}
