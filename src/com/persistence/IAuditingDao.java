package com.persistence;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TPrp;
import com.persistence.entity.TReport;

public interface IAuditingDao {

	public int getAllPage(final TReport report) throws Exception;
	public List<Map<String, String>> query(final TReport report) throws Exception;
	public void setCurrentPage(String currentPage) throws Exception;
	public boolean passAll(final List<String> ids) throws Exception;
	public boolean notPass(final List<String> ids) throws Exception;
	public Map<String, String> queryById(TReport report) throws Exception;
	public boolean update(TReport report) throws Exception;
	public List<Map<String, String>> queryInferior(final List<Map<String, String>> inferiorIds) throws Exception;
	public int getInferiorPage(final List<Map<String, String>> inferiorIds) throws Exception;
}
