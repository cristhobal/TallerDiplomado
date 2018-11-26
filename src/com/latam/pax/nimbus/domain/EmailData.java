package com.latam.pax.nimbus.domain;

import java.io.Serializable;
import java.util.Date;

public class EmailData implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9196951116610113422L;
	private String processName;
	private Date errorDate;
	private String description;
	private String module;
	private String method;
	private String fileError;
	
	public String getFileError() {
		return fileError;
	}
	public void setFileError(String fileError) {
		this.fileError = fileError;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public Date getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((null == fileError) ? 0 : fileError.hashCode());
		result = prime * result + ((null == processName) ? 0 : processName.hashCode());
		result = prime * result + ((null == errorDate) ? 0 : errorDate.hashCode());
		result = prime * result + ((null == description) ? 0 : description.hashCode());
		result = prime * result + ((null == module) ? 0 : module.hashCode());
		result = prime * result + ((null == method) ? 0 : method.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailData other = (EmailData) obj;
		if (null == fileError) {
			if (null != other.fileError)
				return false;
		} else if (!fileError.equals(other.fileError))
			return false;
		if (null == method) {
			if (null !=other.method)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EmailData [fileError=" + fileError + ", processName=" + processName + ", errorDate="
				+ errorDate + ", module=" + module + ", method="
				+ method + "]";
	}

}
