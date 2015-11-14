package com.persistence.entity;

import java.math.BigDecimal;

/**
 * TSyscode entity. @author MyEclipse Persistence Tools
 */

public class TSyscode implements java.io.Serializable {

	// Fields

	private long fid;
	private String fname;
	private String fkey;
	private String fvalue;
	private String parentfkey;

	// Constructors

	/** default constructor */
	public TSyscode() {
	}

	/** full constructor */
	public TSyscode(String fname, String fkey, String fvalue, String parentfkey) {
		this.fname = fname;
		this.fkey = fkey;
		this.fvalue = fvalue;
		this.parentfkey = parentfkey;
	}

	// Property accessors

	public long getFid() {
		return this.fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFkey() {
		return this.fkey;
	}

	public void setFkey(String fkey) {
		this.fkey = fkey;
	}

	public String getFvalue() {
		return this.fvalue;
	}

	public void setFvalue(String fvalue) {
		this.fvalue = fvalue;
	}

	public String getParentfkey() {
		return this.parentfkey;
	}

	public void setParentfkey(String parentfkey) {
		this.parentfkey = parentfkey;
	}

}