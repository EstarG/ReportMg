package com.web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.web.context.request.RequestAttributes;

import com.common.SyscodeUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TReport;
import com.service.IAuditingService;
import com.service.IEmpService;
import com.service.impl.ReportServiceImpl;

public class ReportAuditAction extends ActionSupport implements ModelDriven<TReport>, RequestAware {
	private SyscodeUtils syscode;
	private List<Map<String, String>> statusOps;
	private TReport report = new TReport();
	private IAuditingService auditService;
	private int allPage;
	private String currentPage = null;
	private List<Map<String, String>> auditReports;
	private List<String> ids;
	private String empId;
	private String emp;
	private String proId;
	private String prpId;
	private Map<String, String> reportMap;
	private List<Map<String, String>> empOptions;
	private Map<String, Object> request;
	
	public void init(){
		this.statusOps = syscode.getOption("rstatus");
		
	}
	public String initAudit() throws Exception{
		init();
		if(currentPage != null && !currentPage.equals("")){
			auditService.setCurrentPage(currentPage);
		}else{
			this.currentPage = "1";
			auditService.setCurrentPage(currentPage);
		}
		this.empOptions = this.auditService.empOptions(emp);
		System.out.println("现在的人员数为："+empOptions.size());
		if(empOptions.size()>0){
			this.allPage = this.auditService.getInferiorPage(empOptions);
			this.auditReports = this.auditService.queryInferior(empOptions);
		}else {
			this.allPage = 0;
			this.auditReports = null;
		}
		return "auditQuery";
	}
	public String queryReportAuditAdmin() throws Exception{
		init();
		if(empId != null && !empId.trim().equals("")){
			this.report.getTEmp().setId(Long.parseLong(empId));
		}
		if(currentPage != null && !currentPage.equals("")){
			auditService.setCurrentPage(currentPage);
		}else{
			this.currentPage = "1";
			auditService.setCurrentPage(currentPage);
		}
		this.empOptions = this.auditService.empOptionsAdmin();
		this.allPage = this.auditService.getAllPage(report);
		this.auditReports = this.auditService.queryReport(report);
		return "auditQueryAdmin";
	}
	
	public String queryReportAuditing() throws Exception{
		init();
		if(empId != null && !empId.trim().equals("")){
			this.report.getTEmp().setId(Long.parseLong(empId));
		}
		if(currentPage != null && !currentPage.equals("")){
			auditService.setCurrentPage(currentPage);
		}else{
			this.currentPage = "1";
			auditService.setCurrentPage(currentPage);
		}
		System.out.println("现在的empId为："+empId);
		this.empOptions = this.auditService.empOptions(emp);
		if(this.report.getTEmp().getId() != 0){
//			System.out.println("现在的report的id为："+report.getId());
			System.out.println("现在的report的begin为："+report.getBegin()+"现在的report的end为："+report.getEnd());
			this.allPage = this.auditService.getAllPage(report);
			this.auditReports = this.auditService.queryReport(report);
		}else{
			if(empOptions.size()>0){
				this.allPage = this.auditService.getInferiorPage(empOptions);
				this.auditReports = this.auditService.queryInferior(empOptions);
			}else {
				this.allPage = 0;
				this.auditReports = null;
			}
		}
//		this.allPage = this.auditService.getAllPage(report);
//		this.auditReports = this.auditService.queryReport(report);
		return "auditQuery";
	}
	public String passAll() throws Exception{
		if(ids != null && ids.size()>0){
			this.auditService.passAll(ids);
			request.put("msg", "有"+ids.size()+"条记录通过");
		}
		if(emp != null && !emp.equals("")){
			return "QueryAudit";
		}else{
			return "QueryAuditAdmin";
		}
	}
	public String notPass() throws Exception{
		if(ids != null && ids.size()>0){
			this.auditService.notPass(ids);
			request.put("msg", "有"+ids.size()+"条记录不通过");
		}
		if(emp != null && !emp.equals("")){
			return "QueryAudit";
		}else{
			return "QueryAuditAdmin";
		}
	}
	public String queryAuditById() throws Exception{
		init();
		if(ids != null && ids.size()== 1){
			System.out.println("当前report为：" + ids.get(0));
			report.setId(Long.parseLong(ids.get(0)));
			this.reportMap = this.auditService.queryAuditById(report);
		}
		return "auditUpdate";
	}
	public String updateAudit() throws Exception{
		this.report.getTEmp().setId(Long.parseLong(empId));
		this.report.getTProject().setId(Long.parseLong(proId));
		this.report.getTPrp().setId(Long.parseLong(prpId));
		if(this.auditService.updateAudit(report)){
			request.put("msg", "更新成功");
		}
		if(emp != null && !emp.equals("")){
			return "QueryAudit";
		}else{
			return "QueryAuditAdmin";
		}
		
	}
	
	public TReport getModel() {
		// TODO Auto-generated method stub
		return this.report;
	}

	public TReport getReport() {
		return report;
	}

	public void setReport(TReport report) {
		this.report = report;
	}

	public List<Map<String, String>> getStatusOps() {
		return statusOps;
	}
	public void setAuditService(IAuditingService auditService) {
		this.auditService = auditService;
	}
	public void setSyscode(SyscodeUtils syscode) {
		this.syscode = syscode;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllPage() {
		return allPage;
	}
	public List<Map<String, String>> getAuditReports() {
		return auditReports;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Map<String, String> getReportMap() {
		return reportMap;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public void setPrpId(String prpId) {
		this.prpId = prpId;
	}
	public List<Map<String, String>> getEmpOptions() {
		return empOptions;
	}
	public String getEmpId() {
		return empId;
	}
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	
}
