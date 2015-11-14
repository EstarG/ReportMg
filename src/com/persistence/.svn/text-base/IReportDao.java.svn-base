package com.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.persistence.entity.TProject;
import com.persistence.entity.TReport;



public interface IReportDao {
	public boolean save(TReport report) throws Exception;
	public boolean update(TReport report) throws Exception;
	public boolean delete(TReport report) throws Exception;
	
	
	//分页查询
	public List<Map<String, String>> query(final TReport report);
	//弹出小窗口显示单个日报信息
	public List<Map<String, String>> queryOne(final long id);
	//弹出小窗口显示该日期的日报信息
	public List<Map<String, String>> queryDate(final String cdate);
	//根据日期查询
	public List<Map<String, String>> queryByDate(final TReport report);
	//根据项目查询
	public List<Map<String, String>> queryByProject(final TReport report);
	public int queryAllPageDate(final TReport report) ;
	public int queryAllPageOneDate(final String cdate) ;
	public int queryAllPageProject(final TReport report) ;
	public Map<String, Object>	queryById(final long id) throws Exception;
	public int getCurrentPage() ;
	public void setCurrentPage(int currentPage);
	public int getMaxResult() ;

	public void setMaxResult(int maxResult) ;

	
	public int queryAllPage(final TReport report);
	public int queryReportNumber(final long empId,final String cdate);
	
}
