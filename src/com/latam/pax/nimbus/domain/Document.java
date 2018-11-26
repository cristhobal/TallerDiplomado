package com.latam.pax.nimbus.domain;

import java.io.Serializable;


public class Document extends FileHGSAB implements Serializable{
	private static final long serialVersionUID = 2295301569178517656L;
	private String filePath;
	
	private String group;
	
	private String date;
	private Integer size;
	private ManualLinks links;
	
	public Document(String filePath, String group) {
		super();
		this.filePath = filePath;
		this.group = group;
	}
	
	public Document() {
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}


	public ManualLinks getLinks() {
		return links;
	}

	public void setLinks(ManualLinks links) {
		this.links = links;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public String toString() {
		return "Document [filePath=" + filePath + ", group=" + group + "]";
	}
		
}
