package com.web;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.persistence.entity.TLog;
import com.service.ILogService;

public class LogAction extends ActionSupport implements ModelDriven<TLog>{
	private TLog log = new TLog();
	private ILogService logService;
	private List<Map<String, String>> logs;
	private  String startDate;
	private  String endDate;
	private int currentPage = 1;
	private int allPage;
	
	public String add() throws Exception{
		this.logService.insert(log);
		return null;
	}
	public String querylog() throws Exception{
		if(this.currentPage > 1){
			logService.setCurrentPage(currentPage);
		}else{
			this.currentPage = 1;
		}
		logs = this.logService.findLogs(log,startDate,endDate);
		allPage = (logService.getAllPage(log, startDate, endDate));
		return "qyeryLog";
	}
	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	public TLog getModel() {
		// TODO Auto-generated method stub
		return this.log;
	}
	public TLog getLog() {
		return log;
	}
	public void setLog(TLog log) {
		this.log = log;
	}
	public List<Map<String, String>> getLogs() {
		return logs;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
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
	
}
