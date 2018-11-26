package com.latam.pax.nimbus.domain;

import java.io.Serializable;


public class ManualLinks implements Serializable {

	private static final long serialVersionUID = -4494720680403009675L;

	private String uriManual;

	public String getUriManual() {
		return uriManual;
	}

	public void setUriManual(String uriManual) {
		this.uriManual = uriManual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uriManual == null) ? 0 : uriManual.hashCode());
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
		ManualLinks other = (ManualLinks) obj;
		if (uriManual == null) {
			if (other.uriManual != null)
				return false;
		} else if (!uriManual.equals(other.uriManual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManualLinks [uriManual=" + uriManual + "]";
	}

}
