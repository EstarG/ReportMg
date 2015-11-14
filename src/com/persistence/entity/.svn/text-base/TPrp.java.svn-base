package com.persistence.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TPrp entity. @author MyEclipse Persistence Tools
 */

public class TPrp implements java.io.Serializable {

	// Fields

	private long id;
	private String abbreviate;
	private String name;
	private String remarks;
	private Set TReports = new HashSet(0);
	private Set TProjects = new HashSet(0);

	// Constructors

	/** default constructor */
	public TPrp() {
	}

	/** full constructor */
	public TPrp(String abbreviate, String name, String remarks, Set TReports,
			Set TProjects) {
		this.abbreviate = abbreviate;
		this.name = name;
		this.remarks = remarks;
		this.TReports = TReports;
		this.TProjects = TProjects;
	}
	

	public TPrp(long id) {
		super();
		this.id = id;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAbbreviate() {
		return this.abbreviate;
	}

	public void setAbbreviate(String abbreviate) {
		this.abbreviate = abbreviate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getTReports() {
		return this.TReports;
	}

	public void setTReports(Set TReports) {
		this.TReports = TReports;
	}

	public Set getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set TProjects) {
		this.TProjects = TProjects;
	}
}