package com.chan.uae.teletronics.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author chandra
 *
 */

//Model class
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement

public class DetailExtract implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1341441558405475320L;
	private String projectId;
	private String title;
	private String url;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public DetailExtract(String projectId, String title, String url) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.url = url;
	}
	public DetailExtract() {
		super();
		// TODO Auto-generated constructor stub
	}

}
