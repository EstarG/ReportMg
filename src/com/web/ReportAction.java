package com.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import org.apache.struts2.interceptor.RequestAware;

import com.common.SyscodeUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.IEmpDao;
import com.persistence.entity.TReport;
import com.service.IProjectService;
import com.service.IPrpService;
import com.service.IReportService;


public class ReportAction extends ActionSupport implements ModelDriven<TReport>,RequestAware{
	private IReportService reportService;
	private TReport report = new TReport();
	private Map<String, Object> r = new HashMap<String, Object>();
	private List<Map<String, String>> statusOptions;
	private SyscodeUtils syscode;
	private IEmpDao emp;
	private IProjectService project;
	private IPrpService prp;
	private List<Map<String, String>> empOptions;
	private Map<String, Object> request;						
	private List<Map<String, String>> projectOptions;
	private List<Map<String, String>> prpOptions;
	private List<Map<String, String>> reports;
	private List<Map<String, Object>> reportPage;
	private int currentPage;
	private int allPage;
	
	private long empId;
	private String empName;
	
	private long projectId;
	private long prpId;
	private int sumwork = 0;
	private int sumover = 0;
	private long pro;
	
	//记录未写日报情况
	private List<Map<String,String>> writeReportDetail = new ArrayList<Map<String,String>>();
	private List<String> titleDate;
	private Map<String,String> reportNumber;
	private long deptId;

	
	public void init() throws Exception{
		this.statusOptions=this.syscode.getOption("rstatus");
		this.empOptions = this.emp.getEmpOptions();
		this.projectOptions = this.project.queryAllKV(String.valueOf(this.empId));
			
		System.out.println(this.projectOptions);
		
	}
	
	public String initAdd() throws Exception{
		this.init();
		return "addReport";
	}
	public String getPrps(){
		this.projectId=this.pro;
		
		try {
			this.prpOptions = this.prp.getProjectPrps(String.valueOf(projectId));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		System.out.println("add>>>>>>>>>:"+this.prpOptions);
		//将list中的所有map对象转换为json字符串
		return "success";
	}
	public String add()throws Exception{
		this.init();
		report.getTEmp().setId(this.empId);
		System.out.println("empId:"+this.empId);
	    report.getTProject().setId(this.projectId);
	    report.getTPrp().setId(this.prpId);	    
		this.reportService.addReport(report);
		this.request.put("msg", "添加成功！！");
		System.out.println("addReport success!!");
		return "addReport";
	}
	public String update()throws Exception{
		System.out.println("empId:"+this.empId+" projectId :"+this.projectId + " prp ID " + this.prpId );
		this.init();
		
		
		report.getTEmp().setId(empId);
	    report.getTProject().setId(projectId);
	    report.getTPrp().setId(prpId);
		this.reportService.updateReport(report);
		this.request.put("msg", "更新成功！！");
		return "queryReport";
	}
	//多条件查询，限制用户只能查询个人的日报
	public String query()throws Exception{
		this.init();
		
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		report.getTEmp().setId(this.empId);
		report.getTProject().setId(this.projectId);
		report.getTPrp().setId(this.prpId);
		
		this.reports=this.reportService.queryReport(report);
		System.out.println("action      >>>>>"+this.reports);

		this.allPage=this.reportService.queryAllPage(report);
	
		return "showPerson";
	}
	//根据日期查询
	public String queryByDate()throws Exception{
		this.init();
		
		System.out.println("员工列表。。" + this.empOptions);
		
		report.getTEmp().setId(this.empId);
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		
		this.reports=this.reportService.queryByDate(report);
		sumover = sumwork = 0;
		for(Map<String, String> m:reports){
			
			sumwork = sumwork + Integer.valueOf(m.get("workload"));
			sumover = sumover + Integer.valueOf(m.get("overtime"));
			
		}
		this.allPage=this.reportService.queryAllPageDate(report);
		
		System.out.println("总页数 " + allPage + " 总记录  " + this.reports);
		
		return "showDate";
	}
	//根据项目查询
	public String queryByProject()throws Exception{
		
		this.init();
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		//......
		this.report.getTEmp().setId(empId);
		this.reports=this.reportService.queryByProject(report);
		System.out.println("搜到的日报。。" + this.reports);
		sumover = sumwork = 0;
		for(Map<String, String> m:reports){
			
			sumwork = sumwork + Integer.valueOf(m.get("workload"));
			sumover = sumover + Integer.valueOf(m.get("overtime"));
			
		}
		this.allPage=this.reportService.queryAllPageProject(report);
	
		return "showProject";
		
	}
	//导出表时的查询 按项目
	public String queryExport() {
		System.out.println("。。。。导表.....");
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		//......
	
		this.reports=this.reportService.queryByProject(report);
		System.out.println("搜到的日报。。" + this.reports);
		sumover = sumwork = 0;
		for(Map<String, String> m:reports){
			
			sumwork = sumwork + Integer.valueOf(m.get("workload"));
			sumover = sumover + Integer.valueOf(m.get("overtime"));
			
		}
		this.allPage=this.reportService.queryAllPageProject(report);
		
		return "exportPro";
		
	}
	//导出表时的查询 按日期
	
	public String queryExportByDate() throws Exception {
		
		this.init();
		report.getTEmp().setId(this.empId);
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		this.reports=this.reportService.queryByDate(report);
		sumover = sumwork = 0;
		for(Map<String, String> m:reports){
			
			sumwork = sumwork + Integer.valueOf(m.get("workload"));
			sumover = sumover + Integer.valueOf(m.get("overtime"));
			
		}
		this.allPage=this.reportService.queryAllPageDate(report);
		
		return "exportDate";
	}
	//删除
	public String delete()throws Exception{
		this.init();
		this.reportService.deleteReport(report);
		this.request.put("msg", "删除成功！！");
		return "queryReport";
	}
	//根据id查询
	public String queryById()throws Exception{
		System.out.println("queryById  >>>>>>><<<<<<"+this.empId);

		this.init();
		
		
		report.getTEmp().setId(empId);
		
		this.projectOptions = this.project.queryAllKV(String.valueOf(this.empId));
		
		System.out.println("项目选项 。。 " + this.projectOptions);
			
		System.out.println(this.projectOptions);
			
		
		this.r=this.reportService.queryById(report.getId());
	
		return "update";
	}
	
	public String queryOne()throws Exception{
		this.init();
		this.reports=this.reportService.queryOne(report.getId());
		return "showOne";
	}
	public String queryDate()throws Exception{
		this.init();
		if(this.currentPage!=0){
			this.reportService.setCurrentPage(this.currentPage);
		}
		else{
			this.currentPage=1;
		}
		String date = new SimpleDateFormat("yyyy-MM-dd").format(this.report.getCdate());
		this.reports=this.reportService.queryDate(date);
		this.allPage=this.reportService.queryAllPageOneDate(date);
		return "showByDate";
	}
	
	//查询个人未写日报
	public String queryReportDetail() {
		System.out.println("查询未写日报  该员工   " + this.empId + "名字   " + this.empName);
		
		//设置格式
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
	    SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd EE"); 
		
	    //key时间， value 写日报数量
	    String key  = "";
	    String value = "";
	    
	    this.titleDate = new ArrayList<String>();
	    this.reportNumber = new LinkedHashMap<String, String>();
	    
	    this.titleDate.add("姓名");
	    this.reportNumber.put("name", this.empName);
	    
	    for (int i = -13; i <= 0; ++i) {
	    	
		     java.util.Calendar calstart = java.util.Calendar.getInstance();
		     calstart.setTime(new Date());
		     calstart.add(java.util.Calendar.DAY_OF_WEEK, i);
		     key =  dd.format(calstart.getTime());
		     //时间标头设置
		     this.titleDate.add(key);
		     //该员工写
		     value = this.reportService.queryReportNumber(empId, df.format(calstart.getTime())) + "";
		     this.reportNumber.put(i+"", value);
	    }
		return "queryReportDetail";
	}
	
	//查询下属未写日报
	public String queryAllReport() throws Exception {
		
		//获得下拉列表
		this.empOptions = this.emp.queryofOneDept(this.deptId);
		//设置格式
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
	    SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd EE"); 
		 //key时间， value 写日报数量
	    String key  = "";
	    String value = "";
		
	    
		 this.titleDate = new ArrayList<String>();
		 this.titleDate.add("姓名");
		 for (int i = -13; i <= 0; ++i) {
			  java.util.Calendar calstart = java.util.Calendar.getInstance();
			  calstart.setTime(new Date());
			  calstart.add(java.util.Calendar.DAY_OF_WEEK, i);
			  key =  dd.format(calstart.getTime());
			  //时间标头设置
			  this.titleDate.add(key);
		 }
		 
		 if (this.empId == 0) { 
		 
			 this.writeReportDetail = new ArrayList<Map<String,String>>();
			 List<Map<String,String>> emps = this.emp.queryofOneDept(this.deptId);
			 
			 System.out.println("emps" + emps);
			 for (Map<String,String> e : emps) {
				 System.out.println("ID " + e.get("id") +  " name  " + e.get("name"));
				 this.empId = Long.parseLong(e.get("id"));
				 this.empName = e.get("name");
				
				 //的到这个人的日报
				 this.queryReportDetail();
				 this.writeReportDetail.add(this.reportNumber);
			 }
		 } else {
			 System.out.println("下属   " + empId + " " + empName + "未写日报情况..");
			 this.queryReportDetail();
			 this.writeReportDetail.add(this.reportNumber);
			 
		 }
		 
		 System.out.println("下属写日报情况" + this.writeReportDetail);
		 
		 return "queryAllReport";
		 
	}
	
	
	//get ///set  方法
	public TReport getModel() {
		return this.report;
	}
	
	public IReportService getReportService() {
		return reportService;
	}
	public void setReportService(IReportService reportService) {
		this.reportService = reportService;
	}
	public TReport getReport() {
		return report;
	}
	public void setReport(TReport report) {
		this.report = report;
	}
	public List<Map<String, String>> getStatusOptions() {
		return statusOptions;
	}
	public void setStatusOptions(List<Map<String, String>> statusOptions) {
		this.statusOptions = statusOptions;
	}
	public List<Map<String, String>> getReports() {
		return reports;
	}
	public void setReports(List<Map<String, String>> reports) {
		this.reports = reports;
	}
	public List<Map<String, Object>> getReportPage() {
		return reportPage;
	}
	public void setReportPage(List<Map<String, Object>> reportPage) {
		this.reportPage = reportPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public SyscodeUtils getSyscode() {
		return syscode;
	}
	public void setSyscode(SyscodeUtils syscode) {
		this.syscode = syscode;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public void setPrpId(long prpId) {
		this.prpId = prpId;
	}
	public Map<String, Object> getR() {
		return r;
	}
	public void setR(Map<String, Object> r) {
		this.r = r;
	}
	public int getSumwork() {
		return sumwork;
	}
	public void setSumwork(int sumwork) {
		this.sumwork = sumwork;
	}
	public int getSumover() {
		return sumover;
	}
	public void setSumover(int sumover) {
		this.sumover = sumover;
	}
	public IEmpDao getEmp() {
		return emp;
	}
	public void setEmp(IEmpDao emp) {
		this.emp = emp;
	}
	public List<Map<String, String>> getEmpOptions() {
		return empOptions;
	}
	public void setEmpOptions(List<Map<String, String>> empOptions) {
		this.empOptions = empOptions;
	}
	public IProjectService getProject() {
		return project;
	}
	public void setProject(IProjectService project) {
		this.project = project;
	}
	public IPrpService getPrp() {
		return prp;
	}
	public void setPrp(IPrpService prp) {
		this.prp = prp;
	}
	public List<Map<String, String>> getProjectOptions() {
		return projectOptions;
	}
	public void setProjectOptions(List<Map<String, String>> projectOptions) {
		this.projectOptions = projectOptions;
	}
	public List<Map<String, String>> getPrpOptions() {
		return prpOptions;
	}
	public void setPrpOptions(List<Map<String, String>> prpOptions) {
		this.prpOptions = prpOptions;
	}

	public void setPro(long pro) {
		this.pro = pro;
	}


	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}


	public List<Map<String, String>> getWriteReportDetail() {
		return writeReportDetail;
	}

	public void setWriteReportDetail(List<Map<String, String>> writeReportDetail) {
		this.writeReportDetail = writeReportDetail;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public List<String> getTitleDate() {
		return titleDate;
	}

	public Map<String, String> getReportNumber() {
		return reportNumber;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public long getEmpId() {
		return empId;
	}

	public long getProjectId() {
		return projectId;
	}

	public long getPrpId() {
		return prpId;
	}

	


	
}
