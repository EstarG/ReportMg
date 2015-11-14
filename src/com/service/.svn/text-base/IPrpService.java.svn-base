package com.service;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TPrp;

public interface IPrpService {

	public List<Map<String, String>> queryPrp(final TPrp prp) throws Exception;
	public Map<String, String> queryPrpById(TPrp prp) throws Exception;
	//.....gbx
	public List<Map<String, String>> queryAll() throws Exception ;
	
	public boolean addPrp(TPrp prp) throws Exception;
	public boolean updatePrp(TPrp prp) throws Exception;
	public boolean deletePrp(TPrp prp) throws Exception;
	public boolean deleteAllPrps(List<String> ids) throws Exception;
	public List<Map<String, String>> getProjectPrps(String projectId) throws Exception;
	public int getAllPage(final TPrp prp) throws Exception;
	public void setCurrentPage(String currentPage) throws Exception;
	public List<Map<String, String>> queryPrpAccuracy(final TPrp prp) throws Exception;
}
