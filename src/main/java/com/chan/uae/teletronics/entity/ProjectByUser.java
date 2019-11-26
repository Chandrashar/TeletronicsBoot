package com.chan.uae.teletronics.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class ProjectByUser implements Serializable {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6437974862897848250L;
	
	private String user;	
	private List<DetailExtract> projectDetails;
	public ProjectByUser(String user, List<DetailExtract> projectDetails) {
		super();
		this.user = user;
		this.projectDetails = projectDetails;
	}
	public ProjectByUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<DetailExtract> getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(List<DetailExtract> projectDetails) {
		this.projectDetails = projectDetails;
	}
	
}
