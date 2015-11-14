package com.service.impl;

import java.util.List;
import java.util.Map;

import com.persistence.ILogDao;
import com.persistence.entity.TLog;
import com.service.ILogService;

public class LogServiceImpl implements ILogService{
	private ILogDao logDao;
	public List<Map<String, String>> findLogs(TLog log,String startDate,String endDate) throws Exception {
		// TODO Auto-generated method stub

		return this.logDao.findLogs(log,startDate,endDate);
	}

	public boolean insert(TLog log) throws Exception {
		// TODO Auto-generated method stub
		return this.logDao.insert(log);
	}

	public ILogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}

	public int getAllPage(TLog log, String startDate, String endDate)
			throws Exception {
		// TODO Auto-generated method stub
		return this.logDao.getAllPage(log, startDate, endDate);
	}

	public void setCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		this.logDao.setCurrentPage(currentPage);
	}
}
