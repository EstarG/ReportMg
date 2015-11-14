package com.persistence;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TLog;

public interface ILogDao {
	public boolean insert(TLog log) throws Exception;
	public int getAllPage(final TLog log,final String startDate,final String endDate) throws Exception;
	public List<Map<String, String>> findLogs(final TLog log,final String startDate,final String endDate) throws Exception;
	public void setCurrentPage(int currentPage);
}
