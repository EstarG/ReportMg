package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.persistence.IDeptDao;
import com.persistence.IReportDao;
import com.persistence.entity.TDept;
import com.persistence.entity.TReport;
import com.service.IReportService;

public class ReportServiceImpl implements IReportService {
	private IReportDao reportDao;
	public boolean addReport(TReport report) throws Exception {
	    System.out.println("service:"+report.getTask());
		this.reportDao.save(report);
		return true;
	}

	public boolean deleteReport(TReport report) throws Exception {
		this.reportDao.delete(report);
		return true;
	}

	public int queryAllPage(TReport report) {
		return this.reportDao.queryAllPage(report);
	
	}
	public int queryAllPageOneDate(final String cdate){
		return this.reportDao.queryAllPageOneDate(cdate);
	}
	public int queryAllPageDate(TReport report) {
		return this.reportDao.queryAllPageDate(report);
	
	}
	public int queryAllPageProject(TReport report) {
		return this.reportDao.queryAllPageProject(report);
	
	}
	public int queryReportNumber(final long empId,final String cdate){
		return this.reportDao.queryReportNumber(empId, cdate);
	}
	public Map<String, Object> queryById(long id) throws Exception {
		System.out.println("service id:"+id);
		return this.reportDao.queryById(id);
		
	}
	public List<Map<String,String>> queryOne(final long id){
		return this.reportDao.queryOne(id);
	}
	public List<Map<String,String>> queryDate(final String cdate){
		return this.reportDao.queryDate(cdate);
	}

	public List<Map<String, String>> queryReport(TReport report)
			throws Exception {

		return this.reportDao.query(report);
	}
	public List<Map<String, String>> queryByDate( TReport report){
		
		return this.reportDao.queryByDate(report);
	}
	public List<Map<String, String>> queryByProject( TReport report){
		
		return this.reportDao.queryByProject(report);
	}
	
	public void setCurrentPage(int currentPage) {
		this.reportDao.setCurrentPage(currentPage);

	}

	public void setMaxResult(int maxResult) {
		this.reportDao.setMaxResult(maxResult);
	}

	public boolean updateReport(TReport report) throws Exception {
		return this.reportDao.update(report);
		
	}

	public IReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public static void main(String args[]) throws Exception {
		long empId=155l;
		String cdate="2013-9-12";
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IReportService reportService = (IReportService)ctx.getBean("reportService");
		int num=reportService.queryReportNumber(empId, cdate);
		System.out.println("²éÑ¯¸öÊý£º"+num);
	}


}
