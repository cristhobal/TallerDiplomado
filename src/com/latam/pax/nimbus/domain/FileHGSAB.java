package com.latam.pax.nimbus.domain;

import java.io.Serializable;

public class FileHGSAB implements Serializable {

	private static final long serialVersionUID = 2295301569178517656L;

	private String fileName;

	private byte[] file;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[]  getFile() {
		return file;
	}

	public void setFile(byte[]  file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
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
		FileHGSAB other = (FileHGSAB) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileHGSAB [fileName=" + fileName + "]";
	}
}
