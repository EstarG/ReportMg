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
	
	
	//��ҳ��ѯ
	public List<Map<String, String>> query(final TReport report);
	//����С������ʾ�����ձ���Ϣ
	public List<Map<String, String>> queryOne(final long id);
	//����С������ʾ�����ڵ��ձ���Ϣ
	public List<Map<String, String>> queryDate(final String cdate);
	//�������ڲ�ѯ
	public List<Map<String, String>> queryByDate(final TReport report);
	//������Ŀ��ѯ
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
