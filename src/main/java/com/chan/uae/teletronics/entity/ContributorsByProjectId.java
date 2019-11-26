package com.chan.uae.teletronics.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class ContributorsByProjectId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7016486588656669263L;
	/**
	 * 
	 */
	private String readmeMd;
	private List<String> contributors;
	private int totalCommits;
	
	public String getReadmeMd() {
		return readmeMd;
	}
	public void setReadmeMd(String readmeMd) {
		this.readmeMd = readmeMd;
	}
	public List<String> getContributors() {
		return contributors;
	}
	public void setContributors(List<String> contributors) {
		this.contributors = contributors;
	}
	public int getTotalCommits() {
		return totalCommits;
	}
	public void setTotalCommits(int totalCommits) {
		this.totalCommits = totalCommits;
	}
	public ContributorsByProjectId(String readmeMd, List<String> contributors, int totalCommits) {
		super();
		this.readmeMd = readmeMd;
		this.contributors = contributors;
		this.totalCommits = totalCommits;
	}
	public ContributorsByProjectId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
