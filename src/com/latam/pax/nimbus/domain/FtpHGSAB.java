package com.latam.pax.nimbus.domain;

import java.io.Serializable;


public class FtpHGSAB implements Serializable {

	private static final long serialVersionUID = -6740928431931304518L;

	private Object ftp;

	public Object getFtp() {
		return ftp;
	}

	public void setFtp(Object ftp) {
		this.ftp = ftp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ftp == null) ? 0 : ftp.hashCode());
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
		FtpHGSAB other = (FtpHGSAB) obj;
		if (ftp == null) {
			if (other.ftp != null)
				return false;
		} else if (!ftp.equals(other.ftp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FtpHGSAB [ftp=" + ftp + "]";
	}

}
