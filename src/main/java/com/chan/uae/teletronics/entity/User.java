package com.chan.uae.teletronics.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class User implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3325497684716800780L;
	/**
	 * 
	 */
	private String userName;
	private List<String> assProjectIds;
	
	public User(String userName, List<String> assProjectIds) {
		super();
		this.userName = userName;
		this.setAssProjectIds(assProjectIds);
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<String> getAssProjectIds() {
		return assProjectIds;
	}
	public void setAssProjectIds(List<String> assProjectIds) {
		this.assProjectIds = assProjectIds;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assProjectIds == null) ? 0 : assProjectIds.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (assProjectIds == null) {
			if (other.assProjectIds != null)
				return false;
		} else if (!assProjectIds.equals(other.assProjectIds))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	}
