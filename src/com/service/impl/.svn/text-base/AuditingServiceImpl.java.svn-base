package com.service.impl;

import java.util.List;
import java.util.Map;

import com.persistence.IAuditingDao;
import com.persistence.IEmpDao;
import com.persistence.entity.TReport;
import com.persistence.impl.AuditingDaoImpl;
import com.service.IAuditingService;
import com.service.IEmpService;

public class AuditingServiceImpl implements IAuditingService {

	private IAuditingDao auditingDao;
	private IEmpService empService;
	public int getAllPage(TReport report) throws Exception {
		// TODO Auto-generated method stub
		return auditingDao.getAllPage(report);
	}

	public List<Map<String, String>> queryReport(TReport report)
			throws Exception {
		// TODO Auto-generated method stub
		return auditingDao.query(report);
	}

	public void setAuditingDao(IAuditingDao auditingDao) {
		this.auditingDao = auditingDao;
	}

	public void setCurrentPage(String currentPage) throws Exception {
		this.auditingDao.setCurrentPage(currentPage);
	}

	public boolean passAll(List<String> ids) throws Exception {
		return this.auditingDao.passAll(ids);
	}

	public boolean notPass(List<String> ids) throws Exception {
		return this.auditingDao.notPass(ids);
	}

	public Map<String, String> queryAuditById(TReport report) throws Exception {
		return this.auditingDao.queryById(report);
	}

	public boolean updateAudit(TReport report) throws Exception {
		return this.auditingDao.update(report);
	}

	public List<Map<String, String>> empOptions(String id) throws Exception {
		return this.empService.queryofOneDept(Long.parseLong(id));
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}

	public int getInferiorPage(List<Map<String, String>> inferiorIds)
			throws Exception {
		return this.auditingDao.getInferiorPage(inferiorIds);
	}

	public List<Map<String, String>> queryInferior(
			List<Map<String, String>> inferiorIds) throws Exception {
		return this.auditingDao.queryInferior(inferiorIds);
	}

	public List<Map<String, String>> empOptionsAdmin() throws Exception {
		return this.empService.getEmpOptions();
	}
}
