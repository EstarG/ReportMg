package com.service;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TReport;


public interface IReportService {
	public boolean addReport(TReport report) throws Exception;
	public boolean updateReport(TReport report) throws Exception;
	public boolean deleteReport(TReport report) throws Exception;
	public List<Map<String, String>> queryReport(TReport report) throws Exception;
	public List<Map<String, String>> queryByDate(TReport report);
	public List<Map<String, String>> queryByProject(TReport report);
	public void setCurrentPage(int currentPage);
	public void setMaxResult(int maxResult);
	public Map<String, Object>  queryById(long id)throws Exception;
	public int queryAllPage(final TReport report);
	public int queryAllPageDate(final TReport report);
	public int queryAllPageProject(final TReport report);
	public List<Map<String,String>> queryOne(final long id);
	public List<Map<String,String>> queryDate(final String cdate);
	public int queryAllPageOneDate(final String cdate);
	public int queryReportNumber(final long empId,final String cdate);
}
