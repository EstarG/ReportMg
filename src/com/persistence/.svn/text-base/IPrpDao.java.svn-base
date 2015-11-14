package com.persistence;

import java.util.List;
import java.util.Map;

import com.persistence.entity.TPrp;

public interface IPrpDao {

	public List<Map<String, String>> query(final TPrp prp) throws Exception;
	public Map<String, String> queryById(final TPrp prp) throws Exception;
	
	//gbx....
	public List<Map<String, String>> queryAll() throws Exception ;
	
	public boolean save(TPrp prp) throws Exception;
	public boolean update(TPrp prp) throws Exception;
	public boolean delete(TPrp prp) throws Exception;
	public boolean deleteAll(List<String> ids) throws Exception;
	public List<Map<String, String>> getProjectPrps(String projectId) throws Exception;
	public int getAllPage(final TPrp prp) throws Exception;
	public void setCurrentPage(String currentPage) throws Exception;
	public List<Map<String, String>> queryAccuracy(final TPrp prp) throws Exception; 
}
