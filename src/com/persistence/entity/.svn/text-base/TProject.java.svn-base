package com.persistence.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TProject entity. @author MyEclipse Persistence Tools
 */

public class TProject implements java.io.Serializable {

	// Fields

	private long id;
	private String projectid;
	private String name;
	private String status;
	private Date begindate;
	private Date enddate;
	private String pmanager;
	private String rdmanager;
	private String mkmanager;
	private String qtmanager;
	private String other;
	private String remark;
	private Set TReports = new HashSet(0);
	private Set TEmps = new HashSet(0);
	private Set TPrps = new HashSet(0);
	private Set TDepts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProject() {
	}

	/** full constructor */
	public TProject(String projectid, String name, String status,
			Date begindate, Date enddate, String pmanager, String rdmanger,
			String mkmanager, String qtmanager, String other, String remark,
			Set TReports, Set TEmps, Set TPrps, Set TDepts) {
		this.projectid = projectid;
		this.name = name;
		this.status = status;
		this.begindate = begindate;
		this.enddate = enddate;
		this.pmanager = pmanager;
		this.rdmanager = rdmanager;
		this.mkmanager = mkmanager;
		this.qtmanager = qtmanager;
		this.other = other;
		this.remark = remark;
		this.TReports = TReports;
		this.TEmps = TEmps;
		this.TPrps = TPrps;
		this.TDepts = TDepts;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectid() {
		return this.projectid;
	}

	public TProject(long id) {
		super();
		this.id = id;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPmanager() {
		return this.pmanager;
	}

	public void setPmanager(String pmanager) {
		this.pmanager = pmanager;
	}

	

	public String getRdmanager() {
		return rdmanager;
	}

	public void setRdmanager(String rdmanager) {
		this.rdmanager = rdmanager;
	}

	public String getMkmanager() {
		return this.mkmanager;
	}

	public void setMkmanager(String mkmanager) {
		this.mkmanager = mkmanager;
	}

	public String getQtmanager() {
		return this.qtmanager;
	}

	public void setQtmanager(String qtmanager) {
		this.qtmanager = qtmanager;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTReports() {
		return this.TReports;
	}

	public void setTReports(Set TReports) {
		this.TReports = TReports;
	}

	public Set getTEmps() {
		return this.TEmps;
	}

	public void setTEmps(Set TEmps) {
		this.TEmps = TEmps;
	}

	public Set getTPrps() {
		return this.TPrps;
	}

	public void setTPrps(Set TPrps) {
		this.TPrps = TPrps;
	}

	public Set getTDepts() {
		return this.TDepts;
	}

	public void setTDepts(Set TDepts) {
		this.TDepts = TDepts;
	}
	public void clearManager(){
		pmanager = rdmanager=  mkmanager= qtmanager= other = null;
	}

}