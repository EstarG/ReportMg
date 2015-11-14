package com.service;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TReport;

public interface IAuditingService {

	public int getAllPage(final TReport report) throws Exception;
	public List<Map<String, String>> queryReport(final TReport report) throws Exception;
	public void setCurrentPage(String currentPage) throws Exception;
	public boolean passAll(final List<String> ids) throws Exception;
	public boolean notPass(final List<String> ids) throws Exception;
	public Map<String, String> queryAuditById(TReport report) throws Exception;
	public boolean updateAudit(TReport report) throws Exception;
	public List<Map<String, String>> empOptions(String id) throws Exception;
	public List<Map<String, String>> empOptionsAdmin() throws Exception;
	public List<Map<String, String>> queryInferior(final List<Map<String, String>> inferiorIds) throws Exception;
	public int getInferiorPage(final List<Map<String, String>> inferiorIds) throws Exception;
}
